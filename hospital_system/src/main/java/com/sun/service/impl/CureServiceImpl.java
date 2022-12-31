package com.sun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Cure;
import com.sun.entity.Patient;
import com.sun.entity.vo.PatientVO;
import com.sun.entity.vo.RegisterVO;
import com.sun.mapper.CureMapper;
import com.sun.service.CureService;
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

    @Override
    public List<PatientVO> findByCureId(Integer cureId) {
        List<PatientVO> list = cureMapper.findByCureId(cureId);
        return list;
    }
}
