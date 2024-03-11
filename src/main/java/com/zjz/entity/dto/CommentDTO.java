package com.zjz.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 接收评论数据
 */
public class CommentDTO {
    /**
     * 父评论的id
     */
    private String aaa;
    /**
     * 评论的帖子id
     */
    private String postId;
    /**
     * 评论的内容
     */
    private String content;
   
    /**
     *评论用户的名字
     */
    private String username;
    /**
     * 被回复人的名字
     */
    private String repliedName;

}
