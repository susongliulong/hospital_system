package com.sun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("mapping3119009062liulong")
public class Mapping {
    @TableId(type= IdType.AUTO)
    private Integer Id;
    private Integer medId;
    private Integer priId;
    private Integer number;
    private String description;
    private String dayUsage;
}
