package com.sun.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.entity.Medicine;
import com.sun.mapper.MedicineMapper;
import com.sun.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService {

    @Resource
    private MedicineMapper medicineMapper;

    @Override
    public void updateMedicine(List<Medicine> list) {

        for (Medicine medicine : list) {
            Integer id = medicine.getId();
            UpdateWrapper<Medicine> medicineUpdateWrapper = new UpdateWrapper<>();
            Integer number = medicine.getNumber();
            medicineMapper.updateMedicine(id,number);
            Medicine targetMedicine = medicineMapper.selectById(id);
            medicineUpdateWrapper.eq("id",id).set("number",targetMedicine.getNumber()-number);
            medicineMapper.update(null,medicineUpdateWrapper);
        }
    }
}
