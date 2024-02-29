package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.Bed;
import com.sun.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BedMapper extends BaseMapper<Bed> {

    @Select("SELECT pat.*\n" +
            "FROM prescribe3119009062liulong pre,patient3119009062liulong pat,make3119009062liulong make\n" +
            "WHERE pat.`id`=make.`patient_id` AND make.`pri_id`=pre.`id`\n" +
            "AND pre.`is_in_patient`=1;")
    List<Patient> findInpatients();
}
