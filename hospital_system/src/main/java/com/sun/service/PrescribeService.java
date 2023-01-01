package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Prescribe;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PrescribeService extends IService<Prescribe> {

    void insert(Integer cureId, Integer prescribeId);

    Integer findPrescribeId(Integer registerId);

    String findDescription(Integer prescribeId);
}
