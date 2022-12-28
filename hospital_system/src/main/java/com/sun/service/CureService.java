package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Cure;
import com.sun.entity.Department;
import com.sun.entity.vo.RegisterVO;

import java.util.List;

public interface CureService extends IService<Cure> {

    List<RegisterVO> findByPatientId(String patientId);
}
