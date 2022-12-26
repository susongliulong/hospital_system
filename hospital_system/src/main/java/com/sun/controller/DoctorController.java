package com.sun.controller;

import com.sun.common.R;
import com.sun.entity.Doctor;
import com.sun.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public R register(@RequestBody Doctor doctor){

        try{
            doctorService.saveDoctor(doctor);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(null,"操作失败");
        }
        return R.success("账号修改注册成功");
    }

    @GetMapping("/login")
    public R login(String name, String password, HttpServletRequest httpServletRequest){
        R result= doctorService.findByPassword(name,password);
        httpServletRequest.getSession().getServletContext().setAttribute("doctor",result.getResult());
        return result;
    }

}
