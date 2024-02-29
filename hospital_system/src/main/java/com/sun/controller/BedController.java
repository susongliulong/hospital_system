package com.sun.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.entity.Bed;
import com.sun.entity.Medicine;
import com.sun.entity.Patient;
import com.sun.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class BedController {


    @Autowired
    private BedService bedService;

    @PostMapping("/addBed")
    public R addBed(@RequestBody String beds){

        JSONObject jsonObject = JSONObject.parseObject(beds);
        Object jsonString = jsonObject.get("beds");
        List<Bed> list = JSONArray.parseArray((String)jsonString, Bed.class);
        for (Bed bed : list) {
            boolean result = bedService.updateById(bed);
            if(!result){
                bedService.save(bed);
            }
        }
        return R.success(null,"床位信息修改成功");
    }

    @GetMapping("/findAll")
    public R findAll(){
        return R.success(bedService.list());
    }

    @GetMapping("/findInPatients")
    public R findInPatients(){

        List<Patient> patients=bedService.findInPatients();
        return R.success(patients);
    }

    @PostMapping("/allocateBed")
    public R allocateBed(String patientId,String bedId){
        Bed bed = bedService.getById(bedId);
        bed.setPatId(patientId);
        bed.setState(true);
        bedService.updateById(bed);
        return R.success(null,"提交成功");
    }

    @DeleteMapping("/deletePatientToBed")
    public R deletePatientToBed(String bedId){
        Bed bed = bedService.getById(bedId);
        bed.setPatId(null);
        bed.setState(false);
        bedService.updateById(bed);
        return R.success(null,"删除成功");
    }
}
