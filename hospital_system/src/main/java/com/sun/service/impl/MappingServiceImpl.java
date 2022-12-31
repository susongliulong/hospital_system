package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.LoginLocation;
import com.sun.entity.Mapping;
import com.sun.mapper.LoginLocationMapper;
import com.sun.mapper.MappingMapper;
import com.sun.service.LoginLocationService;
import com.sun.service.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl extends ServiceImpl<MappingMapper, Mapping> implements MappingService {

}
