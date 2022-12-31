package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sun.common.R;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.entity.Doctor;
import com.sun.entity.Register;
import com.sun.entity.dto.DoctorDTO;
import com.sun.entity.vo.DoctorVO;
import com.sun.service.CureService;
import com.sun.service.DepartmentService;
import com.sun.service.DoctorService;
import com.sun.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterController {


    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private CureService cureService;

    /**
     * 返回各个部门下医生的个人信息
     *
     * @return
     */
    @GetMapping("/findAll")
    public R findAll() {
        /*
        定义列表cureMessage，存储DoctorVo元素
        调用MP提供的list方法返回所有的部门信息，记为departments
        遍历departments，对于每一个元素department
        根据部门的id调用doctorMapper下的方法，返回该部门下医生的信息List<Doctor> doctors
        将部门的名称和doctors封装成DoctorVO对象，并且添加到cureMessage当中
         */
        LinkedList<DoctorVO> cureMessage = new LinkedList<>();
        List<Department> departments = departmentService.list();
        for (Department department : departments) {
            List<Doctor> doctors = doctorService.list(new LambdaQueryWrapper<Doctor>().eq(Doctor::getDepId, department.getId()));
            DoctorVO doctorVO = new DoctorVO();
            doctorVO.setDepartmentName(department.getName());
            doctorVO.setDoctors(doctors);
            cureMessage.add(doctorVO);
        }
        return R.success(cureMessage);
    }

    @PostMapping("/register")
    public R register(Integer cureId, String patientId) {
        Register register = new Register();
        register.setCureId(cureId);
        register.setPatId(patientId);
        registerService.save(register);

        //查询出诊信息
        Cure cure = cureService.getById(cureId);
        cure.setNumber(cure.getNumber() + 1);//当前人数加1
        if (cure.getNumber().equals(cure.getTotal())) {
            cure.setState(0);//状态修改
        }

        cureService.updateById(cure);
        return R.success("处理过程很成功");
    }

    /**
     * patient个人界面，请求的挂号信息
     * @param patientId
     * @return
     */
    @GetMapping("/findByPatientId")
    public R findByPatientId(String patientId) {
        return R.success(cureService.findByPatientId(patientId));
    }

    /**
     * 删除挂号信息
     * @param registerId
     * @return
     */
    @DeleteMapping("/cancel")
    public R cancel(Integer registerId){
        Register register = registerService.getById(registerId);
        registerService.removeById(registerId);
        Integer cureId = register.getCureId();

        Cure cure = cureService.getById(cureId);
        cure.setNumber(cure.getNumber()-1);
        if(cure.getNumber()<cure.getTotal()){
            cure.setState(1);
        }
        cureService.updateById(cure);

        return R.success(null,"删除成功");
    }

    @PostMapping("/updateState")
    public void updateState(String patientId,Integer cureId){
        UpdateWrapper<Register> registerUpdateWrapper = new UpdateWrapper<>();
        registerUpdateWrapper.eq("pat_id",patientId).eq("cure_id",cureId).set("is_succeed",1);
        registerService.update(null,registerUpdateWrapper);
    }
}
