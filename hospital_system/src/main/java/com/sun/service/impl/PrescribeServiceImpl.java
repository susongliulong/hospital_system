package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Prescribe;
import com.sun.mapper.PrescribeMapper;
import com.sun.service.PrescribeService;
import org.springframework.stereotype.Service;

@Service
public class PrescribeServiceImpl extends ServiceImpl<PrescribeMapper, Prescribe> implements PrescribeService {

}
