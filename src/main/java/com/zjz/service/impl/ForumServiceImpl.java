package com.zjz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjz.entity.PageResult;
import com.zjz.entity.dto.ForumPostDTO;
import com.zjz.entity.dto.GoodCountDTO;
import com.zjz.entity.dto.LikeRecordDTO;
import com.zjz.entity.po.*;
import com.zjz.mapper.ForumMapper;
import com.zjz.mapper.LoginMapper;
import com.zjz.service.ForumService;
import com.zjz.untils.BeansUtils;
import com.zjz.untils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumMapper forumMapper;
    @Resource
    private LoginMapper loginMapper;
    /**
     * 根据类型查询论坛帖子
     * @param pageNum
     * @param pageSize
     * @param type
     * @param path
     * @return
     */
    @Override
    public Result showForumArticle(int pageNum, int pageSize, String type, String path) {
        if (type.equals("全部")){
            PageHelper.startPage(pageNum, pageSize);
            Page<ForumPost> page = forumMapper.getAllForumArticle(type);
            PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
            return new Result().result200(pageResult, path);
        }else {
            PageHelper.startPage(pageNum, pageSize);
            Page<ForumPost> page = forumMapper.getForumArticleByType(type);
            PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
            return new Result().result200(pageResult, path);
        }

    }

    /**
     * 保存帖子
     * @param forumPostDTO
     * @param path
     * @return
     */
    @Override
    public Result saveForumPost(ForumPostDTO forumPostDTO, String path) {
        //拷贝UserDTO里面的属性到User并进行属性增加
        ForumPost forumPost = BeansUtils.beanCopy(forumPostDTO,ForumPost.class);
        User user = loginMapper.getByUsername(forumPost.getUsername());
        forumPost.setStatus(0);
        forumPost.setCommentCount(0);
        forumPost.setGoodCount(0);
        forumPost.setPostId(UUID.randomUUID().toString());
        forumPost.setUserId(user.getUserId());
        forumPost.setPostTime(System.currentTimeMillis());
        forumMapper.saveForumPost(forumPost);

        return new Result().result200("发布成功", path);
    }

    /**
     * 根据postId返回post内容
     * @param postId
     * @param path
     * @return
     */
    @Override
    public Result getPostContent(String postId, String path) {
        ForumPost forumPost = forumMapper.getPostContentById(postId);
        return new Result().result200(forumPost, path);
    }

    /**
     * 点赞
     * @param likeRecordDTO
     * @param path
     * @return
     */
    @Override
    public Result like(LikeRecordDTO likeRecordDTO, String path) {
        System.out.println(likeRecordDTO);
        LikeRecord likeRecord = new LikeRecord();
        User user = loginMapper.getByUsername(likeRecordDTO.getUsername());
        likeRecord.setLikeType(likeRecordDTO.getLikeType());
        likeRecord.setCreateTime(System.currentTimeMillis());
        likeRecord.setAuthorUserId(likeRecordDTO.getAuthorUserId());
        likeRecord.setObjectId(likeRecordDTO.getObjectId());
        likeRecord.setUserId(user.getUserId());
        //查询之前有没有点赞记录
        LikeRecord liked = forumMapper.getLikeRecord(user.getUserId(), likeRecordDTO.getObjectId());
       if (liked != null){
           //删除点赞记录
           forumMapper.deleteLikeRecord(user.getUserId(), likeRecordDTO.getObjectId());
           //如果是文章点赞
           if (likeRecordDTO.getLikeType().equals("0")){
               forumMapper.deletePostGoodCountById(likeRecordDTO.getObjectId());
           }
           //如果是点赞用户
           if (likeRecordDTO.getLikeType().equals("1")){
               forumMapper.deleteCommentGoodCountById(likeRecordDTO.getObjectId());
           }
           return new Result().result200("取消点赞", path);
       }
        forumMapper.saveLike(likeRecord);
       //增加帖子的点赞数量
        if (likeRecordDTO.getLikeType().equals("0")){
            boolean b = forumMapper.addPostGoodCountById(likeRecordDTO.getObjectId());
            System.out.println(b);
        }
        //增加评论的点赞数量
        if (likeRecordDTO.getLikeType().equals("1")){
            System.out.println("增加用户评论点赞数量执行了吗");
            boolean b = forumMapper.addCommentGoodCountById(likeRecordDTO.getObjectId());
            System.out.println("bbbbbb" + b);
        }
        return new Result().result200("点赞成功", path);
    }

    /**
     * 获取点赞数
     * @param goodCountDTO
     * @param path
     * @return
     */
    @Override
    public Result getGoodCount(GoodCountDTO goodCountDTO, String path) {
        //文章点赞类型
        if (goodCountDTO.getType().equals("0")){
            //forumMapper.getGoodCount(id)
        }
        //用户点赞类型
       if (goodCountDTO.getType().equals("1")){
          int goodCount =  forumMapper.getGoodCountById(goodCountDTO.getId());
          return new Result().result200(goodCount, path);
       }
      return null;
    }

    /**
     * 获取用户的点赞记录
     * @param username
     * @param path
     * @return
     */
    @Override
    public Result getUserLike(String username, String path) {
        System.out.println(username + "11111111");
        User user = loginMapper.getByUsername(username);
        List<String> likeRecordList =forumMapper.getUserLikeByUserId(user.getUserId());
        if (likeRecordList.isEmpty()){
            return new Result().result200(likeRecordList, path);
        }else {
            List<ForumPost> forumPostByList = forumMapper.getForumPostByList(likeRecordList);
            return new Result().result200(forumPostByList, path);
        }

    }

    /**
     * 获取用户的发帖记录
     * @param username
     * @param path
     * @return
     */
    @Override
    public Result getUserForumPost(String username, String path) {
        List<ForumPost> forumPostList = forumMapper.getUserForumPostByUsername(username);
        return new Result().result200(forumPostList, path);
    }

    /**
     * 获取用户的评论记录
     * @param username
     * @param path
     * @return
     */
    @Override
    public Result getUserComment(String username, String path) {
        List<String> commentList=forumMapper.getUserCommentByUsername(username);
        if (commentList.isEmpty()){
            return new Result().result200(commentList, path);
        }else {
            List<ForumPost> forumPostList =  forumMapper.getForumPostByList(commentList);
            return new Result().result200(forumPostList, path);
        }

    }

}
