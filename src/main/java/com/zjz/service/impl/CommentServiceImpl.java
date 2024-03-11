package com.zjz.service.impl;

import com.zjz.entity.dto.CommentDTO;
import com.zjz.entity.po.Comment;
import com.zjz.entity.po.ForumPost;
import com.zjz.entity.po.User;
import com.zjz.entity.vo.CommentVO;
import com.zjz.mapper.CommentMapper;
import com.zjz.mapper.ForumMapper;
import com.zjz.mapper.LoginMapper;
import com.zjz.service.CommentService;
import com.zjz.untils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private LoginMapper loginMapper;
    @Resource
    private ForumMapper forumMapper;

    /**
     * 保存评论
     * @param commentDTO
     * @param path
     * @return
     */
    @Override
    public Result createComment(CommentDTO commentDTO, String path) {
        User user = loginMapper.getByUsername(commentDTO.getUsername());
        Comment comment = new Comment();
        comment.setCommentId(UUID.randomUUID().toString());
        comment.setPCommentId(commentDTO.getAaa());
        comment.setContent(commentDTO.getContent());
        comment.setPostId(commentDTO.getPostId());
        comment.setUsername(commentDTO.getUsername());
        comment.setUserId(user.getUserId());
        comment.setPostTime(System.currentTimeMillis());
        comment.setRepliedName(commentDTO.getRepliedName());
        if (commentDTO.getAaa() == null){
            commentMapper.updateCommentCount(commentDTO.getPostId());
        }
        //返回文章回复次数
        ForumPost postContentById = forumMapper.getPostContentById(commentDTO.getPostId());
        int row = commentMapper.saveComment(comment);
        if(row<1){
            return new Result().result404("评论失败", path);
        }else {
            Map<String, Object> map = new HashMap<>(2);
            map.put("message","评论成功");
            map.put("commentCount",postContentById.getCommentCount());
            return new Result().result200(map, path);
        }
    }

    /**
     * 展示一个帖子的所有评论
     * @param postId
     * @param path
     * @return
     */
    @Override
    public Result showComment(String postId, String path) {
        //把该articleId下的所有的一级评论查找并存放到CommentVOList里
        List<CommentVO> commentVOList = commentMapper.selectPCommentByArticleId(postId);
        //把commentVOList里的每一条一级评论的子评论查找并存放到对应的一级评论中
        commentVOList = getComment(commentVOList, postId);
        return new Result().result200(commentVOList, path);
    }


    /**
     * 拿到所有一级评论的子评论
     * @param commentVOList 所有一级评论
     * @return List<Comment> 返回值
     */
    private List<CommentVO> getComment(List<CommentVO> commentVOList, String postId) {

        for (CommentVO comment: commentVOList) {
//            // 拿到该评论的用户名
//            comment.setUsername(userMapper.selectNameById(comment.getUserId()));
            // 通过comment.getCommentId()拿到该评论的所有子评论
            List<CommentVO> commentVO = commentMapper.selectByParentId(comment.getCommentId(), postId);
            // 把该评论的所有子评论 放到这个方法 递归(循环)：用这个方法拿取 子评论 的 子评论 。
            // 子评论 的 子评论 也会拿它的子评论，递归(循环) 直到 子评论 的 子评论 的... 拿不到它的 子评论 为止
            List<CommentVO> commentVOS = getComment(commentVO, postId);
            //把子评论放入一级评论中
            comment.setCommentVOList(commentVOS);
        }
        return commentVOList;
    }

}
