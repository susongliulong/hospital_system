package com.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Doctor;
import com.sun.entity.Patient;
import com.sun.entity.People;
import com.sun.mapper.PatientMapper;
import com.sun.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    public Patient findByPatient(Patient patient) {

        LambdaQueryWrapper<Patient> patientLambdaQueryWrapper = new LambdaQueryWrapper<>();

        //根据姓名查询
        patientLambdaQueryWrapper.eq(StringUtils.isNotBlank(patient.getName()), Patient::getName, patient.getName());

        //根据电话号码查询
        patientLambdaQueryWrapper.eq(StringUtils.isNotBlank(patient.getTelephone()), Patient::getTelephone, patient.getTelephone());

        return patientMapper.selectOne(patientLambdaQueryWrapper);
    }

    @Override
    public void savePatient(Patient patient) {

        LambdaQueryWrapper<Patient> patientLambdaQueryWrapper = new LambdaQueryWrapper<>();
        patientLambdaQueryWrapper.eq(Patient::getIdNumber,patient.getIdNumber());

        if(patientMapper.selectOne(patientLambdaQueryWrapper)==null){

            //用户尚未注册
            patientMapper.insert(patient);
        }else{
            //需要更新相关信息
            patientMapper.update(patient,patientLambdaQueryWrapper);
        }
    }
}
