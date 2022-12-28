package com.sun.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RegisterVO {
    private Integer id;
    private Date date;
    private String time;
    private String department;
    private String location;
    private String doctorName;
    private Integer price;
}
