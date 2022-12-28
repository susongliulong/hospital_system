package com.sun.entity.dto;

import com.sun.entity.Doctor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DoctorDTO {
    private String departName;
    private String doctorId;
    private String doctorName;
}
