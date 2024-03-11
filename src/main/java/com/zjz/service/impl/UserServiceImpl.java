package com.zjz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjz.entity.PageResult;
import com.zjz.entity.po.*;
import com.zjz.mapper.LoginMapper;
import com.zjz.mapper.SchoolInfoMapper;
import com.zjz.service.UserService;
import com.zjz.untils.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SchoolInfoMapper schoolInfoMapper;
    @Resource
    private LoginMapper loginMapper;


    /**
     * 返回对应学校的院校简介
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result schoolIntroduction(String schoolName, String path) {
        String introduction = schoolInfoMapper.getIntroductionByName(schoolName);
        return new Result().result200(introduction,path);
    }

    /**
     * 根据学校id分页查询招生简章
     * @param pageNum 页码
     * @param pageSize 每页显示的数量
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result generalRegulations(int pageNum, int pageSize, String schoolName,String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<GeneralRegulations> page = schoolInfoMapper.getGeneralRegulationsBySchoolName(schoolName);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult, path);
    }

    /**
     * 查询对应学校的学费奖励
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result schoolTuition(String schoolName, String path) {
        String tuition = schoolInfoMapper.getSchoolTuitionBySchoolName(schoolName);
        return new Result().result200(tuition, path);
    }

    /**
     * 分页查询学校录取信息
     * @param pageNum
     * @param pageSize
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result admission(int pageNum, int pageSize, String schoolName, String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Admission> page = schoolInfoMapper.getAdmissionBySchoolName(schoolName);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult, path);
    }

    /**
     * 根据标题查询具体的招生简章内容
     * @param title
     * @param path
     * @return
     */
    @Override
    public Result generalRegulationsContent(String title, String path) {
        String content = schoolInfoMapper.generalRegulationsContent(title);
        return new Result().result200(content,path);
    }

    /**
     * 根据标题查询具体的内容
     * @param title
     * @param path
     * @return
     */
    @Override
    public Result admissionContent(String title, String path) {
        String content = schoolInfoMapper.getAdmissionContentByTitle(title);
        return new Result().result200(content, path);
    }

    /**
     * 获取所有院校的信息
     * @param path
     * @return
     */
    @Override
    public Result allSchoolIntroduction(String path) {
        List<School> schoolList = schoolInfoMapper.getAllSchoolIntroduction();
        if (schoolList == null){
            return new Result().result404("获取学校信息失败",path);
        }
        System.out.println(schoolList);
        return new Result().result200(schoolList,path);
    }

    /**
     * 分页查询指定学校的所有资料文章
     * @param pageNum
     * @param pageSize
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result schoolAllArticle(int pageNum, int pageSize, String schoolName, String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Article> page = schoolInfoMapper.getArticleBySchoolName(schoolName);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult, path);

    }

    /**
     * 根据学校名字，返回所有文章类型
     * @param schoolName
     * @param path
     * @return
     */
    @Override
    public Result schoolAllArticleType(String schoolName, String path) {
        List<String> schoolAllArticleType = schoolInfoMapper.getSchoolAllArticleType(schoolName);
        return new Result().result200(schoolAllArticleType, path);
    }

    /**
     * 查询指定学校下的指定类型的所有文章
     * @param pageNum
     * @param pageSize
     * @param schoolName
     * @param articleType
     * @param path
     * @return
     */
    @Override
    public Result schoolAllArticleByType(int pageNum, int pageSize, String schoolName, String articleType, String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Article> page = schoolInfoMapper.getSchoolAllArticleByType(schoolName,articleType);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult,path);
    }

    /**
     * 获取所有资料
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Result getAllArticle(int pageNum, int pageSize,String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Article> page = schoolInfoMapper.getAllArticle();
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult,path);
    }

    /**
     * 返回指定学校指定文章的具体内容
     * @param articleId
     * @param path
     * @return
     */
    @Override
    public Result getArticleConcreteContent(String articleId, String path) {
        Article article = schoolInfoMapper.getArticleConcreteContentById(articleId);
        return new Result().result200(article, path);
    }

    /**
     * 更新用户信息
     * @param file
     * @param username
     * @param personalProfile
     * @param selectedInstitution
     * @param s
     * @return
     */
    @Override
    public Result updateUserInfo(MultipartFile file, String username, String personalProfile, String selectedInstitution,String s) throws IOException {
        if (file.isEmpty()) {
            return new Result().result500("上传文件不能为空",s);
        }
        //获取文件后缀
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //修改文件的名字
        String fileName = new Date().getTime()+"."+fileExt;
        //文件保存的路径
        String path = "C:\\Users\\63167\\Desktop\\考研前端\\template-mundana-bootstrap-html-master\\assets\\img"+"/"+fileName;
        File dest = new File(path);
        //保存上传的文件
        file.transferTo(dest);
        User byUsername1 = loginMapper.getByUsername(username);
        //保存记录
        User user = new User();
        user.setUserId(byUsername1.getUserId());
        user.setHeadSculpture(fileName);
        user.setPersonalProfile(personalProfile);
        user.setSelectedInstitution(selectedInstitution);
        boolean b = loginMapper.updateUserInfo(user);
        Map<String, Object> map = new HashMap<>(2);
        map.put("message","更新成功");
        map.put("filename",fileName);

        return new Result().result200(map, s);
    }

    /**
     * 返回用户所有的信息
     * @param username
     * @param path
     * @return
     */
    @Override
    public Result getUserInfo(String username, String path) {
        User byUsername = loginMapper.getByUsername(username);
        return new Result().result200(byUsername, path);
    }


}
