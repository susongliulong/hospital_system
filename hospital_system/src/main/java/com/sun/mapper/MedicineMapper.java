package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.LoginLocation;
import com.sun.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {

    @Update("UPDATE medicine3119009062liulong\n" +
            "SET number=number-1\n" +
            "WHERE id=5")
    void updateMedicine(Integer id, Integer n);
}
