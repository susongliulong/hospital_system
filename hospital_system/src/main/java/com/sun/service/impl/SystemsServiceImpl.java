package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.common.Systems;
import com.sun.mapper.SystemsMapper;
import com.sun.service.SystemsService;
import org.springframework.stereotype.Service;

@Service
public class SystemsServiceImpl extends ServiceImpl<SystemsMapper, Systems> implements SystemsService {

}
