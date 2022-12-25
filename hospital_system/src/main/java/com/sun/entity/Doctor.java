package com.sun.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@TableName("doctor3119009062liulong")
public class Doctor extends People{

    private String title;//职称
    private String depId;//部门编号
    private Date startWork;//开始工作时间
    private String degree;//学位
    private String description;//个人描述
    private String feature;//擅长领域
}
