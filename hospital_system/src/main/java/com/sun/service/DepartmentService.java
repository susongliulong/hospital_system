package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Department;
import com.sun.entity.dto.DoctorDTO;

import java.util.List;

public interface DepartmentService extends IService<Department> {

    List<DoctorDTO> findAll();
}
