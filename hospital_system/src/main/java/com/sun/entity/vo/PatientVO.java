package com.sun.entity.vo;

import com.sun.entity.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientVO extends Patient {
    private Integer isSucceed;
}
