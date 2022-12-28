package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Department;
import com.sun.entity.dto.DoctorDTO;
import com.sun.mapper.DepartmentMapper;
import com.sun.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<DoctorDTO> findAll() {
        return departmentMapper.findAll();
    }
}
