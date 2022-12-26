package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.common.R;
import com.sun.entity.Doctor;

public interface DoctorService extends IService<Doctor> {

    //医生注册或者修改个人信息
    public void saveDoctor(Doctor doctor);

    R findByPassword(String name, String password);
}
