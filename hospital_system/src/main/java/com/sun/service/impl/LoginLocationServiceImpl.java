package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.LoginLocation;
import com.sun.mapper.LoginLocationMapper;
import com.sun.service.LoginLocationService;
import org.springframework.stereotype.Service;

@Service
public class LoginLocationServiceImpl extends ServiceImpl<LoginLocationMapper,LoginLocation> implements LoginLocationService {

}
