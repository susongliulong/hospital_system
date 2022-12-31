package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.LoginLocation;
import com.sun.entity.Medicine;

import java.util.List;

public interface MedicineService extends IService<Medicine> {

    void updateMedicine(List<Medicine> list);
}
