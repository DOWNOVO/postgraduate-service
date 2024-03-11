package com.zjz.mapper;

import com.zjz.entity.po.Comment;
import com.zjz.entity.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int saveComment(Comment comment);

    List<CommentVO> selectPCommentByArticleId(String postId);

    List<CommentVO> selectByParentId(String commentId, String postId);

    boolean updateCommentCount(String postId);
}
