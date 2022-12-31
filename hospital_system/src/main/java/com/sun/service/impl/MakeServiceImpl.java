package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Make;
import com.sun.mapper.MakeMapper;
import com.sun.service.MakeService;
import org.springframework.stereotype.Service;

@Service
public class MakeServiceImpl extends ServiceImpl<MakeMapper, Make> implements MakeService {
    
}
