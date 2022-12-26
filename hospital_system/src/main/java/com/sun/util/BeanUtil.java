package com.sun.util;

import com.sun.entity.Cure;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil {

    public static Cure copyCure(Cure original,String doctorId){
        Cure cure = new Cure();
        cure.setDate(original.getDate());
        cure.setTime(original.getTime());
        cure.setDepartment(original.getDepartment());
        cure.setPrice(original.getPrice());
        cure.setTotal(original.getTotal());
        cure.setDoctorId(doctorId);
        return cure;
    }
}
