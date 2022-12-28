package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Register;
import com.sun.mapper.RegisterMapper;
import com.sun.service.RegisterService;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {

}
