package com.sun.util;

import com.sun.entity.Cure;
import com.sun.entity.Mapping;
import com.sun.entity.Medicine;
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

    public static Mapping copyPrescribe(Medicine medicine,Integer priId){

        Mapping mapping = new Mapping();
        mapping.setDayUsage(medicine.getDayUsage());
        mapping.setDescription(medicine.getAttention());
        mapping.setMedId(medicine.getId());
        mapping.setNumber(medicine.getNumber());
        mapping.setPriId(priId);
        return mapping;
    }
}
