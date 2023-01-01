package com.sun.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.LocalIdThread;
import com.sun.common.R;
import com.sun.entity.Make;
import com.sun.entity.Mapping;
import com.sun.entity.Medicine;
import com.sun.entity.Prescribe;
import com.sun.entity.Register;
import com.sun.entity.vo.MappingVO;
import com.sun.entity.vo.PrescribeVO;
import com.sun.service.*;
import com.sun.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/prescribe")
public class PrescribeController {
    @Autowired
    private MakeService makeService;
    @Autowired
    private MappingService mappingService;
    @Autowired
    private PrescribeService prescribeService;
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LocalIdThread<Integer> localIdThread;

    @PostMapping("/addPrescribe")
    @Transactional
    public R addPrescribe(String doctorId,
                          String patientId,
                          String description,
                          Integer cureId,
                          String date,
                          Integer isInPatient,@RequestBody String medicines) throws Exception{

        //生成处方信息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = simpleDateFormat.parse(date);
        prescribeService.save(new Prescribe(isInPatient,parseDate,description));
        Integer prescribeId = localIdThread.get();

        Register register = registerService.getOne(new LambdaQueryWrapper<Register>().eq(Register::getPatId, patientId).eq(Register::getCureId, cureId));

        prescribeService.insert(prescribeId,register.getId());
        //插入数据到mapping表中
        JSONObject jsonObject = JSONObject.parseObject(medicines);
        Object jsonString = jsonObject.get("medicines");
        List<Medicine> list = JSONArray.parseArray((String)jsonString, Medicine.class);

        for (Medicine medicine : list) {
            mappingService.save(BeanUtil.copyPrescribe(medicine,prescribeId));
        }

        //处理make表信息
        Make make = new Make();
        make.setDocId(doctorId);
        make.setPatientId(patientId);
        make.setPriId(prescribeId);
        makeService.save(make);

        medicineService.updateMedicine(list);

        return R.success(null,"处方信息处理成功");
    }

    @PostMapping("/test")
    public void test( @RequestBody Medicine []medicines){
        System.out.println(Arrays.toString(medicines));
    }

    @GetMapping("/findPrescribesById")
    public R findPrescribesById(String patientId,Integer []prescribeIds){

        LinkedList<Integer> result = new LinkedList<>();
        if(prescribeIds==null||prescribeIds.length<=0){
            return R.warning(null,"没有就诊信息");
        }
        for (Integer prescribeId : prescribeIds) {
            List<Register> list = registerService.list(new LambdaQueryWrapper<Register>()
                    .eq(Register::getPatId, patientId).eq(Register::getId, prescribeId));
            for (Register register : list) {
                if(register.getIsSucceed()==1){
                    result.push(register.getId());
                }
            }
        }
        return R.success(result);
    }

    @GetMapping("/findPrescribes")
    public R findPrescribes(Integer registerId){
        PrescribeVO prescribeVO = new PrescribeVO();
        //根据registerId在register_prescribe表中查询具体的prescribeId
        Integer prescribeId=prescribeService.findPrescribeId(registerId);
        //根据prescribeId在prescribe表中查询症状信息返回,封装成String字符串
        String description=prescribeService.findDescription(prescribeId);
        prescribeVO.setDescription(description);
//        //根据prescribeId在mapping表中查询具体的药物的med_id
        List<MappingVO> medicines=mappingService.findByPrescribeId(prescribeId);
        prescribeVO.setMedicineData(medicines);
        return R.success(prescribeVO);
    }
}
