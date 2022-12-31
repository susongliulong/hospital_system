package com.sun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("medicine3119009062liulong")
public class Medicine extends SimpleMedicine{
    private Date productionTime;//生成日期
    private Date expireTime;//过期时间
    private String attention;//使用注意事项
}
