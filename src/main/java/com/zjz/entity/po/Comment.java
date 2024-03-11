package com.zjz.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /**
     * 评论id
     */
    private String commentId;

    /**
     * 父评论的id
     */
    private String pCommentId;
    /**
     * 评论的帖子id
     */
    private String postId;
    /**
     * 评论的内容
     */
    private String content;
    /**
     * 评论的用户id
     */
    private int userId;
    /**
     *评论用户的名字
     */
    private String username;

    /**
     * 点赞数
     */
    private int goodCount;
    /**
     * 发布的时间
     */
    private long postTime;
    /**
     * 帖子状态
     */
    private int status;
    /**
     * 被回复的人的姓名
     */
    private String repliedName;

}
