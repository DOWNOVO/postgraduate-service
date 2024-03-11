package com.zjz.mapper;

import com.github.pagehelper.Page;
import com.zjz.entity.po.Comment;
import com.zjz.entity.po.ForumPost;
import com.zjz.entity.po.LikeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ForumMapper {
    Page<ForumPost> getForumArticleByType(String type);

    Page<ForumPost> getAllForumArticle(String type);

    boolean saveForumPost(ForumPost forumPost);

    ForumPost getPostContentById(String postId);

    boolean saveLike(LikeRecord likeRecord);

    LikeRecord getLikeRecord(int userId, String objectId);

    boolean deleteLikeRecord(int userId, String objectId);

    boolean deletePostGoodCountById(String objectId);

    boolean addPostGoodCountById(String objectId);

    boolean deleteCommentGoodCountById(String objectId);

    boolean addCommentGoodCountById(String objectId);

    int getGoodCountById(String id);

    List<String> getUserLikeByUserId(int userId);

    List<ForumPost> getUserForumPostByUsername(String username);

    List<String> getUserCommentByUsername(String username);

    List<ForumPost> getForumPostByList(List<String> list);
}
