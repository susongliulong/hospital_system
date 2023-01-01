package com.sun.entity.vo;

import com.sun.entity.Mapping;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MappingVO extends Mapping {
    private String name;
    private float price;
}
