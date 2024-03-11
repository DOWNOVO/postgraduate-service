package com.zjz.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

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
     * 被回复人的名字
     */
    private String repliedName;
    /**
     * 该评论的所有子评论
     */
    private List<CommentVO> commentVOList;

}
