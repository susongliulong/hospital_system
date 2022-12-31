package com.sun.config;


import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.sun.common.LocalIdThread;
import com.sun.entity.Doctor;
import com.sun.entity.Patient;
import com.sun.entity.Prescribe;
import com.sun.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Slf4j
@Component
/**
 * 自定义id的生成策略
 */
public class CustomIdGenerator implements IdentifierGenerator {


    @Autowired
    private LocalIdThread<Integer> localIdThread;

    @Override
    public Number nextId(Object entity) {

        int id=0;
        if(entity.getClass()== Prescribe.class){
            id=Integer.parseInt( StringUtil.generateRandomString(6));
            localIdThread.set(id);
        }
        return id;
    }

    @Override
    public String nextUUID(Object entity) {
        StringBuffer stringBuffer = new StringBuffer();
        if(entity.getClass()== Patient.class) {
            //处理病人
            stringBuffer.append('3');
            Patient patient = (Patient) entity;
            if (patient.getSex().equals("男")) {
                stringBuffer.append('1');
            } else {
                stringBuffer.append('2');
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String birthday = simpleDateFormat.format(patient.getBirthday());
            stringBuffer.append(birthday);
            //截取序列号
            stringBuffer.append(StringUtil.generateRandomString(4));
            log.info("进入到{}，生成的id为{}","patient",stringBuffer.toString());
        }
        if(entity.getClass()== Doctor.class) {
            //处理病人
            stringBuffer.append('2');
            Doctor doctor = (Doctor) entity;
            if (doctor.getSex().equals("男")) {
                stringBuffer.append('1');
            } else {
                stringBuffer.append('2');
            }
            stringBuffer.append(doctor.getDepId());
            //截取序列号
            stringBuffer.append(StringUtil.generateRandomString(3));
            log.info("进入到{}，生成的id为{}","doctor",stringBuffer.toString());
        }
        return stringBuffer.toString();
    }
}
