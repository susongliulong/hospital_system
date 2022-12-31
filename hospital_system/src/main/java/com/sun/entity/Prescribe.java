package com.sun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("prescribe3119009062liulong")
public class Prescribe {
    @TableId(type= IdType.ASSIGN_ID)
    private Integer id;
    private Integer isInPatient;//是否需要住院
    private Date time;
    private String description;

    public Prescribe(Integer isInPatient, Date time, String description) {
        this.isInPatient = isInPatient;
        this.time = time;
        this.description = description;
    }
}
