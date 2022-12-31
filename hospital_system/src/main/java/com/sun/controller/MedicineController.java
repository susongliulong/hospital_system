package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.entity.Medicine;
import com.sun.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {


    @Autowired
    private MedicineService medicineService;

    @GetMapping("/findAll")
    public R findAll(){
        List<Medicine> list = medicineService.list();
        return R.success(list);
    }

    @GetMapping("/findMedicinesByKeyword")
    public R findMedicinesByKeyword(String keyWord){

        List<Medicine> list = medicineService.list(new LambdaQueryWrapper<Medicine>()
                .like(Medicine::getName, keyWord).or().like(Medicine::getAttention, keyWord));
        return R.success(list);
    }
}
