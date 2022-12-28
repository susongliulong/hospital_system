package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.entity.vo.RegisterVO;
import com.sun.mapper.CureMapper;
import com.sun.mapper.DepartmentMapper;
import com.sun.service.CureService;
import com.sun.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CureServiceImpl extends ServiceImpl<CureMapper, Cure> implements CureService {

    @Resource
    private CureMapper cureMapper;

    @Override
    public List<RegisterVO> findByPatientId(String patientId) {
        return cureMapper.findByPatientId(patientId);
    }
}
