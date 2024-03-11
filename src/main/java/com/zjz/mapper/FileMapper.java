package com.zjz.mapper;

import com.github.pagehelper.Page;
import com.zjz.entity.po.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    boolean save(Information information);

    Page<Information> getAllInformation();

    Page<Information> getInformationByType(String type);

    String getInfoPathById(String infoId);

}
