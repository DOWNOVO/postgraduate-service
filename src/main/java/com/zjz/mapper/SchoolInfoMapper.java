package com.zjz.mapper;

import com.github.pagehelper.Page;

import com.zjz.entity.po.Admission;
import com.zjz.entity.po.Article;
import com.zjz.entity.po.GeneralRegulations;
import com.zjz.entity.po.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolInfoMapper {
    String getIntroductionByName(String schoolName);

    Page<GeneralRegulations> getGeneralRegulationsBySchoolName(String schoolName);

    String getSchoolTuitionBySchoolName(String schoolName);

    Page<Admission> getAdmissionBySchoolName(String schoolName);

    String generalRegulationsContent(String title);

    String getAdmissionContentByTitle(String title);

    List<School> getAllSchoolIntroduction();

    Page<Article> getArticleBySchoolName(String schoolName);

    List<String> getSchoolAllArticleType(String schoolName);

    Page<Article> getSchoolAllArticleByType(String schoolName, String articleType);

    Page<Article> getAllArticle();

    Article getArticleConcreteContentById(String articleId);
}
