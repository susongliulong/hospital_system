package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.mapper.CureMapper;
import com.sun.mapper.DepartmentMapper;
import com.sun.service.CureService;
import com.sun.service.DepartmentService;
import org.springframework.stereotype.Service;


@Service
public class CureServiceImpl extends ServiceImpl<CureMapper, Cure> implements CureService {

}
