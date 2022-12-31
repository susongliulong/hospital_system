package com.sun.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleMedicine {
    private Integer id;//药品编号
    private String name;//药品名称
    private float price;//药品价格
    private Integer number;//药品总数量
    private String dayUsage;//使用方法
}
