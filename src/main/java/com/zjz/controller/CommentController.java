package com.zjz.controller;


import com.zjz.entity.dto.CommentDTO;
import com.zjz.service.CommentService;
import com.zjz.untils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 评论
 */
@RestController
@CrossOrigin
public class CommentController {
    @Resource
    private CommentService commentService;


    /**
     * 接收评论
     * @param commentDTO
     * @return
     */
    @PostMapping("/comment")
    public Result createComment(@RequestBody CommentDTO commentDTO){
        return commentService.createComment(commentDTO,"/hbb/comment");
    }

    /**
     * 展示所有评论
     * @param postId
     * @return
     */
    @RequestMapping("/showComment")
    public Result showComment(String postId){
        return commentService.showComment(postId,"/hbb/showComment");
    }


}
