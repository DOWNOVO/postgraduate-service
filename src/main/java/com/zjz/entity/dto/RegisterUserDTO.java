package com.zjz.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
    /**
     * 昵称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
}
