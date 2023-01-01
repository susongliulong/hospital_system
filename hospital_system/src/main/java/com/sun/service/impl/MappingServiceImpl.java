package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.LoginLocation;
import com.sun.entity.Mapping;
import com.sun.entity.vo.MappingVO;
import com.sun.mapper.LoginLocationMapper;
import com.sun.mapper.MappingMapper;
import com.sun.service.LoginLocationService;
import com.sun.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MappingServiceImpl extends ServiceImpl<MappingMapper, Mapping> implements MappingService {

    @Resource
    private MappingMapper mappingMapper;

    @Override
    public List<MappingVO> findByPrescribeId(Integer prescribeId) {

        return mappingMapper.findPrescribesById(prescribeId);
    }
}
