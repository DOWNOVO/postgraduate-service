package com.zjz.service;

import com.zjz.entity.po.Information;
import com.zjz.untils.Result;

public interface FileService {
    boolean saveInformation(Information information);

    Result getAllInformation(int pageNum, int pageSize,String path);

    Result getTypeInformation(int pageNum, int pageSize, String type, String path);

    String getInformationPath(String infoId);
}
