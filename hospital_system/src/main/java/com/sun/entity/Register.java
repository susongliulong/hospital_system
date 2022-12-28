package com.sun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("register3119009062liulong")
public class Register {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String patId;
    private Integer cureId;//出诊信息id
    private Integer isFinished;//是否完成缴费
    private Integer isSucceed;//是否完成报道
}
