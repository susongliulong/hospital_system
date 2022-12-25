package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Patient;

public interface PatientService extends IService<Patient> {

    public Patient findByPatient(Patient patient);

    public void savePatient(Patient patient);
}
