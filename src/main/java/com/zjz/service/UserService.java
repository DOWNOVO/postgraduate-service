package com.zjz.service;

import com.zjz.untils.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    Result schoolIntroduction(String schoolName, String path);

    Result generalRegulations(int pageNum, int pageSize, String schoolName,String path);

    Result schoolTuition(String schoolName, String path);

    Result admission(int pageNum, int pageSize, String schoolName, String path);

    Result generalRegulationsContent(String title, String path);

    Result admissionContent(String title, String path);

    Result allSchoolIntroduction(String path);

    Result schoolAllArticle(int pageNum, int pageSize,String schoolName, String path);

    Result schoolAllArticleType(String schoolName, String path);

    Result schoolAllArticleByType(int pageNum, int pageSize, String schoolName, String articleType, String path);

    Result getAllArticle(int pageNum, int pageSize,String path);

    Result getArticleConcreteContent(String articleId, String path);

    Result updateUserInfo(MultipartFile file, String username, String personalProfile, String selectedInstitution,String path) throws IOException;

    Result getUserInfo(String username, String path);
}
