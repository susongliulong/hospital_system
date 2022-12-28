package com.sun.entity.vo;

import com.sun.entity.Cure;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CureVO {
    private String location;
    private List<Cure> cures;
}
