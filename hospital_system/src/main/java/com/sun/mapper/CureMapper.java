package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.entity.vo.RegisterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CureMapper extends BaseMapper<Cure> {

    @Select("SELECT cure.date,cure.time,department.name as department,department.location,doctor.name as doctorName,cure.price,register.`id`\n" +
            "FROM cure3119009062liulong cure,department3119009062liulong department,\n" +
            "doctor3119009062liulong doctor,register3119009062liulong register\n" +
            "WHERE cure.id=register.cure_id AND cure.department=department.name\n" +
            "AND cure.doctor_id=doctor.id AND register.pat_id=#{patientId}")
    List<RegisterVO> findByPatientId(String patientId);
}
