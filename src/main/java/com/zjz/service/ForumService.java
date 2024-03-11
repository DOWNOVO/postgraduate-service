package com.zjz.service;

import com.zjz.entity.dto.ForumPostDTO;
import com.zjz.entity.dto.GoodCountDTO;
import com.zjz.entity.dto.LikeRecordDTO;
import com.zjz.untils.Result;

public interface ForumService {
    Result showForumArticle(int pageNum, int pageSize, String type, String path);

    Result saveForumPost(ForumPostDTO forumPostDTO, String path);

    Result getPostContent(String postId, String path);

    Result like(LikeRecordDTO likeRecordDTO, String path);

    Result getGoodCount(GoodCountDTO goodCountDTO,String path);

    Result getUserLike(String username, String path);

    Result getUserForumPost(String username, String path);

    Result getUserComment(String username, String path);
}
