package com.zjz.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private int articleId;
    private String schoolName;
    private String articleType;
    private String articleTitle;
    private String articleContent;
    private long addedTime;

}
