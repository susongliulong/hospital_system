package com.sun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.entity.Mapping;
import com.sun.entity.vo.MappingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MappingMapper extends BaseMapper<Mapping> {

    @Select("SELECT mapping.*,medicine.`name`,medicine.`price`\n" +
            "FROM mapping3119009062liulong mapping,medicine3119009062liulong medicine\n" +
            "WHERE mapping.`med_id`=medicine.`id`\n" +
            "AND pri_id=#{priId}")
    List<MappingVO> findPrescribesById(Integer priId);
}
