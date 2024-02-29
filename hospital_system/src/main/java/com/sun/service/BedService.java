package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Bed;
import com.sun.entity.Patient;

import java.util.List;

public interface BedService extends IService<Bed> {

    List<Patient> findInPatients();
}
