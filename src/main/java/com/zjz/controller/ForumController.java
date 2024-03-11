package com.zjz.controller;


import com.zjz.entity.dto.ForumPostDTO;
import com.zjz.entity.dto.GoodCountDTO;
import com.zjz.entity.dto.LikeRecordDTO;
import com.zjz.service.ForumService;
import com.zjz.untils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/forum")
public class ForumController {
    @Resource
    private ForumService forumService;

    /**
     * 根据类型展示论坛帖子,当type值为全部时候，返回所有帖子
     */
    @RequestMapping("/showForumArticle")
    public Result showForumArticle(int pageNum, int pageSize, String type){
        return forumService.showForumArticle(pageNum,pageSize,type,"/hbb/forum/showForumArticle");
    }

    /**
     * 保存帖子
     */
    @PostMapping("/saveForumPost")
    public Result saveForumPost(@RequestBody ForumPostDTO forumPostDTO){
        return forumService.saveForumPost(forumPostDTO,"/hbb/forum/saveForumPost");
    }

    /**
     * 根据postId来查找帖子具体内容
     */
    @RequestMapping("/getPostContent")
    public Result getPostContent(String postId){
        return forumService.getPostContent(postId,"/hbb/forum/getPostContent");
    }

    /**
     * 点赞
     */
    @RequestMapping("/like")
    public Result like(@RequestBody LikeRecordDTO likeRecordDTO){
        return forumService.like(likeRecordDTO,"/hbb/forum/like");
    }

    /**
     * 点赞
     */
    @RequestMapping("/getGoodCount")
    public Result getGoodCount(@RequestBody GoodCountDTO goodCountDTO){
        return forumService.getGoodCount(goodCountDTO,"/hbb/forum/getGoodCount");
    }

    /**
     * 返回指定用户的点赞记录
     */
    @RequestMapping("/getUserLike")
    public Result getUserLike(String username){
        return forumService.getUserLike(username,"/hbb/forum/getUserLike");
    }

    /**
     * 返回指定用户的发帖记录
     */
    @RequestMapping("/getUserForumPost")
    public Result getUserForumPost(String username){
        return forumService.getUserForumPost(username,"/hbb/forum/getUserForumPost");
    }

    /**
     * 返回用户的评论记录
     */
    @RequestMapping("/getUserComment")
    public Result getUserComment(String username){
        return forumService.getUserComment(username,"/hbb/forum/getUserComment");
    }

}
