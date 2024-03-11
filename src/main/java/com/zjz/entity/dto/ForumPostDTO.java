package com.zjz.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumPostDTO {
    /**
     * 板块名字
     */
    private String boardName;
    /**
     * 发帖用户名
     */
    private String username;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子内容
     */
    private String content;

}
