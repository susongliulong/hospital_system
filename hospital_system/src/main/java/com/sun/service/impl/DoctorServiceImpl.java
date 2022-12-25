package com.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Doctor;
import com.sun.mapper.DoctorMapper;
import com.sun.service.DoctorService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public void saveDoctor(Doctor doctor) {

        LambdaQueryWrapper<Doctor> doctorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        doctorLambdaQueryWrapper.eq(Doctor::getIdNumber,doctor.getIdNumber());

        if(doctorMapper.selectOne(doctorLambdaQueryWrapper)==null){

            //用户尚未注册
            doctorMapper.insert(doctor);
        }else{
            //需要更新相关信息
            doctorMapper.update(doctor,doctorLambdaQueryWrapper);
        }
    }
}
