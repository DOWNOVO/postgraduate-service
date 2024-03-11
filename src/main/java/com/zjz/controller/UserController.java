package com.zjz.controller;

import cn.hutool.http.HttpResponse;
import com.zjz.entity.dto.ForgetCipherDTO;
import com.zjz.entity.dto.LoginUserDTO;
import com.zjz.entity.dto.RegisterUserDTO;
import com.zjz.service.UserLoginService;
import com.zjz.service.UserService;
import com.zjz.untils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserLoginService userLoginService;

    @Resource
    private UserService userService;
    /**
     * 注册
     * @param registerUserDTO
     * @return
     */
    @PostMapping("/registerUser")
    public Result postSaveUser(@RequestBody RegisterUserDTO registerUserDTO){

        return userLoginService.registerUser(registerUserDTO,"/hbb/user/registerUser");
    }

    /**
     * 登录
     * @param loginUserDTO
     * @return
     */

    @PostMapping("/loginUser")
    public Result loginUser(@RequestBody LoginUserDTO loginUserDTO){
        return userLoginService.loginUser(loginUserDTO,"/hbb/user/loginUser");
    }

    /**
     * 忘记密码
     * @param forgetCipherDTO
     * @return
     */
    @PostMapping("/forgetCipher")
    public Result putEditCipher(@RequestBody ForgetCipherDTO forgetCipherDTO){
        return userLoginService.forgetCipher(forgetCipherDTO,"/hbb/user/forgetCipher");
    }

    /**
     * 获取所有院校的信息
     */
    @RequestMapping("/allSchoolIntroduction")
    public Result allSchoolIntroduction(){

        return userService.allSchoolIntroduction("/hbb/user/allSchoolIntroduction");
    }

    /**
     * 查询对应学校的院校简介
     */
    @RequestMapping("/schoolIntroduction/{schoolName}")
    public Result schoolIntroduction(@PathVariable String schoolName){
        return userService.schoolIntroduction(schoolName,"/hbb/user/schoolIntroduction/{schoolName}");
    }

    /**
     * 查询对应学校的学费奖励
     */
    @RequestMapping("/schoolTuition/{schoolName}")
    public Result schoolTuition(@PathVariable String schoolName){
        return userService.schoolTuition(schoolName,"/hbb/user/schoolTuition/{schoolName}");
    }

    /**
     * 查询对应学校的录取信息
     */
    @RequestMapping("/admission")
    public Result admission(int pageNum, int pageSize,String schoolName) throws Exception{
        return userService.admission(pageNum,pageSize,schoolName,"/hbb/user/admission");
    }

    /**
     * 分页查询招生简章
     */
    @RequestMapping("/generalRegulations")
    public Result generalRegulations(int pageNum, int pageSize,String  schoolName) throws Exception{
        return userService.generalRegulations(pageNum,pageSize,schoolName,"/hbb/user/generalRegulations");
    }


    /**
     * 根据具体标题查询招生简章具体内容
     */
    @RequestMapping("/generalRegulationsContent/{title}")
    public Result generalRegulationsContent(@PathVariable String title) throws Exception{
        return userService.generalRegulationsContent(title,"/hbb/user/generalRegulationsContent/{title}");
    }

    /**
     * 根据标题查询对应学校的录取信息的具体内容
     */
    @RequestMapping("/admissionContent/{title}")
    public Result admissionContent(@PathVariable String title) throws Exception{
        return userService.admissionContent(title,"/hbb/user/admissionContent/{title}");
    }

    /**
     * 分页查询指定学校的所有资料文章或指定类型的所有文章
     */
    @RequestMapping("/schoolAllArticle")
    public Result schoolAllArticle(int pageNum, int pageSize,String schoolName,String articleType) throws Exception{
        if (articleType.equals("123")){
            return userService.schoolAllArticle(pageNum,pageSize,schoolName,"/hbb/user/schoolAllArticle");
        }else {
            return userService.schoolAllArticleByType(pageNum, pageSize, schoolName, articleType,"/hbb/user/schoolAllArticle");
        }
    }
    /**
     * 分页查询所有学校的所有资料
     */
    @RequestMapping("/allArticle")
    public Result allArticle(int pageNum, int pageSize) throws Exception{
        return  userService.getAllArticle(pageNum,pageSize,"/hbb/user/allArticle");
    }
    /**
     * 根据学校的名字，返回学校下所有资料类型
     */
    @RequestMapping("/schoolAllArticleType/{schoolName}")
    public Result schoolAllArticleType(@PathVariable String schoolName, HttpServletResponse response) throws Exception{
        return userService.schoolAllArticleType(schoolName,"/hbb/user/schoolAllArticleType/{schoolName}");
    }

    /**
     * 查询指定学校，指定资料的具体内容
     */
    @RequestMapping("/getArticleConcreteContent/{articleId}")
    public Result getArticleConcreteContent(@PathVariable String articleId) throws Exception{
        return userService.getArticleConcreteContent(articleId,"/hbb/user/getArticleConcreteContent/{articleId}");
    }

    /**
     * 更新用户信息
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestParam("file") MultipartFile file,String username,String personal_profile,String selected_institution) throws Exception{
        return userService.updateUserInfo(file,username,personal_profile,selected_institution,"/hbb/user/updateUserInfo");
    }

    /**
     * 查询指定学校，指定资料的具体内容
     */
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(String username){
        return userService.getUserInfo(username,"/hbb/user/getUserInfo/{username}");
    }
}
