package com.sun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("bed3119009062liulong")
public class Bed {
    private String id;
    private String building;
    private String location;
    private float price;
    private Boolean state;
    private String patId;
}
