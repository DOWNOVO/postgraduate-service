package com.zjz.entity.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgetCipherDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 第一次新密码
     */
    private String newOnePassword;

    /**
     * 第二次新密码
     */
    private String newTwoPassword;

}
