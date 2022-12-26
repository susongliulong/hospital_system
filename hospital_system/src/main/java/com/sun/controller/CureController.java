package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.entity.Cure;
import com.sun.entity.Doctor;
import com.sun.service.CureService;
import com.sun.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cure")
@Slf4j
public class CureController {

    @Autowired
    private CureService cureService;

    @Autowired
    private DoctorService doctorService;

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
    @GetMapping("/findAll")
    public R findAll(HttpServletRequest httpServletRequest){
        Doctor doctor= (Doctor) httpServletRequest.getSession().getServletContext().getAttribute("doctor");
        return R.success(cureService.list(new LambdaQueryWrapper<Cure>().eq(Cure::getDoctorId,doctor.getId())));
    }
}
