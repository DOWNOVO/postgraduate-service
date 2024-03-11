package com.zjz.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 招生简章
 */
public class GeneralRegulations {
    private String regulationsId;
    private String schoolName;
    private String title;
    private String content;
    private int addedTime;
}
