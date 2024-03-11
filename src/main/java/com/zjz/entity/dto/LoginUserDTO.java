package com.zjz.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
