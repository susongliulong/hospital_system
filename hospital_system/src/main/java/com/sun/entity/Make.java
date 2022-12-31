package com.sun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("make3119009062liulong")
public class Make {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer priId;
    private String docId;
    private String patientId;
}
