package com.sun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("department3119009062liulong")
public class Department {
    private String id;
    private String name;
    private String location;
    private Date founded;
}
