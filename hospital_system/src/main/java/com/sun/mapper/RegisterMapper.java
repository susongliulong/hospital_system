package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.Department;
import com.sun.entity.Register;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RegisterMapper extends BaseMapper<Register> {

}
