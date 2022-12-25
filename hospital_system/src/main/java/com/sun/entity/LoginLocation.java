package com.sun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 记录用户登录的位置
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginLocation {

    private String userId;
    private String location;
}
