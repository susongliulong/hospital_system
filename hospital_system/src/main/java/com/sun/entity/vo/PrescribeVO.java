package com.sun.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
/**
 * 返回病人的处方信息
 */
public class PrescribeVO {
    private String description;
    private List<MappingVO>medicineData;
}
