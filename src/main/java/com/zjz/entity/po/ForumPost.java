package com.zjz.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 论坛帖子
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumPost {
    private String postId;
    private String boardName;
    private int userId;
    private String username;
    private String title;
    private String content;
    private long postTime;
    private int goodCount;
    private int commentCount;
    private int status;
}
