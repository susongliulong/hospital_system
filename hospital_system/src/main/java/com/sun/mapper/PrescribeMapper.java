package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.Prescribe;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface PrescribeMapper extends BaseMapper<Prescribe> {

    @Insert("insert into register_prescribe (prescribe_id,register_id) values(#{prescribe_id},#{register_id})")
    void insertData(@Param("prescribe_id") Integer prescribeId, @Param("register_id") Integer registerId);

    @Select("SELECT prescribe_id\n" +
            "FROM register_prescribe\n" +
            "WHERE register_id=#{registerId}")
    Integer findPrescribeId(Integer registerId);

    @Select("SELECT description\n" +
            "FROM prescribe3119009062liulong\n" +
            "WHERE id=#{id}")
    String findDescription(@Param("id") Integer prescribeId);
}
