package com.zjz.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeRecordDTO {
    /**
     * 点赞的类型，0是帖子点赞，1是评论点赞
     */
    private String likeType;
    /**
     * 被点赞的主体id，可以是用户id可以是帖子id
     */
    private String objectId;
    /**
     * 点赞的id
     */
    private String username;
    /**
     * 被点赞的主体id
     */
    private String authorUserId;
}
