package com.zjz.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *录取信息
 */
public class Admission {
    private String admissionId;
    private String schoolName;
    private String title;
    private String content;
    private long addedTime;

}
