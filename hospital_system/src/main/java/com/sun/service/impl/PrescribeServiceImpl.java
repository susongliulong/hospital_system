package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Prescribe;
import com.sun.mapper.PrescribeMapper;
import com.sun.service.PrescribeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PrescribeServiceImpl extends ServiceImpl<PrescribeMapper, Prescribe> implements PrescribeService {

    @Resource
    private PrescribeMapper prescribeMapper;

    @Override
    public void insert(Integer cureId, Integer prescribeId) {
        prescribeMapper.insertData(cureId,prescribeId);
    }

    @Override
    public Integer findPrescribeId(Integer registerId) {
        return prescribeMapper.findPrescribeId(registerId);
    }

    @Override
    public String findDescription(Integer prescribeId) {
        return prescribeMapper.findDescription(prescribeId);
    }
}
