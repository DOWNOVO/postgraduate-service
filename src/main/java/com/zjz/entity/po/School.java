package com.zjz.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class School implements Serializable {
    /**
     * 学校id
     */
    private int schoolId;
    /**
     * 地理位置
     */
    private String location;
    /**
     * 生活成本
     */
    private String cost;
    /**
     * 就业前景
     */
    private String employment;
    /**
     * 学校名字
     */
    private String name;
    /**
     * 学校简介
     */
    private String introduction;
    /**
     * 学费奖励
     */
    private String tuition;
}
