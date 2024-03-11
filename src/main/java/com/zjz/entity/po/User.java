package com.zjz.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 序号
     */
    private int userId;

    /**
     * 昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限的名字
     */
    private String role;

    /**
     * 推荐的院校
     */
    private String selectedInstitution;
    /**
     * 个人简介
     */
    private String personalProfile;
    /**
     * 头像路径
     */
    private String headSculpture;
}
