package com.sun.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("cure3119009062liulong")
public class Cure {
    private Integer id;
    private Date date;//出诊时间
    private String time;//出诊具体日期
    private String department;//出诊科室
    private Integer total;
    private Integer price;
    private String doctorId;//外键，医生工号
    private Integer state;
    private Integer number;
}
