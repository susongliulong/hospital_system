package com.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Bed;
import com.sun.entity.Patient;
import com.sun.mapper.BedMapper;
import com.sun.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {


    @Resource
    private BedMapper bedMapper;

    @Override
    public List<Patient> findInPatients() {
        return bedMapper.findInpatients();
    }
}
