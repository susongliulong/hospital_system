package com.sun.entity.vo;

import com.sun.entity.Doctor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorVO {
    private String departmentName;
    private List<Doctor> doctors;
}
