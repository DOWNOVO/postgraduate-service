package com.zjz.service;

import com.zjz.entity.dto.CommentDTO;
import com.zjz.untils.Result;

public interface CommentService {
    public Result createComment(CommentDTO commentDTO,String path);

    Result showComment(String postId,String path);
}
