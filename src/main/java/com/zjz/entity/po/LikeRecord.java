package com.zjz.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 点赞记录表
 */
public class LikeRecord {
    private int likeId;
    private String likeType;
    private String objectId;
    private int userId;
    private long createTime;
    private String authorUserId;

}
