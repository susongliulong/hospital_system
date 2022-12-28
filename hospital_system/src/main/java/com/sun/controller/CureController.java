package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.entity.Doctor;
import com.sun.entity.vo.CureVO;
import com.sun.service.CureService;
import com.sun.service.DepartmentService;
import com.sun.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cure")
@Slf4j
public class CureController {

    @Autowired
    private CureService cureService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/post")
    public R update(@RequestBody Cure []cures,String doctorId){

        cureService.remove(new LambdaQueryWrapper<Cure>().eq(Cure::getDoctorId,doctorId));
        for (Cure cure : cures) {
            Cure target = new Cure();
            BeanUtils.copyProperties(cure,target);
            target.setDoctorId(doctorId);
            cureService.save(target);
        }
        return R.success(null,"出诊信息更新成功");

    }

    /**
     * 医生在登录成功以后，在系统展示医生的出诊信息
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/findAll")
    public R findAll(HttpServletRequest httpServletRequest){
        Doctor doctor= (Doctor) httpServletRequest.getSession().getServletContext().getAttribute("doctor");
        return R.success(cureService.list(new LambdaQueryWrapper<Cure>().eq(Cure::getDoctorId,doctor.getId())));
    }

    /**
     * 根据医生的Id查询出诊信息
     * @param id
     * @return
     */
    @GetMapping("findById")
    public R findByDoctorId(String id){
        List<Cure> totalCures = cureService.list(new LambdaQueryWrapper<Cure>().eq(Cure::getDoctorId, id));
        LinkedList<CureVO> result = new LinkedList<>();
        //按照部门的位置进行分组
        //使用java流操作中的map流
        Map<String,List<Cure>> hashmap=totalCures.stream()
                .collect(Collectors.groupingBy(Cure::getDepartment));
        for (String key : hashmap.keySet()) {
            CureVO cureVO = new CureVO();
            Department department = departmentService.getOne(new LambdaQueryWrapper<Department>().eq(Department::getName, key));
            String location = department.getLocation();
            cureVO.setLocation(key+"--"+location);
            cureVO.setCures(hashmap.get(key));
            result.add(cureVO);
        }
        return R.success(result);
    }
}
