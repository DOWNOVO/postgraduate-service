package com.zjz.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjz.entity.PageResult;
import com.zjz.entity.po.Admission;
import com.zjz.service.FileService;
import com.zjz.entity.po.Information;
import com.zjz.mapper.FileMapper;
import com.zjz.untils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileMapper fileMapper;
    /**
     * 保存文件信息
     * @param information
     * @return
     */
    @Override
    public boolean saveInformation(Information information) {
        boolean b = fileMapper.save(information);
        return b;
    }

    /**
     * 分页查询所有资料
     * @param pageNum
     * @param pageSize
     * @param path
     * @return
     */
    @Override
    public Result getAllInformation(int pageNum, int pageSize, String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Information> page = fileMapper.getAllInformation();
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult, path);
    }

    /**
     * 分页查询指定类型的资料
     * @param pageNum
     * @param pageSize
     * @param type
     * @param path
     * @return
     */
    @Override
    public Result getTypeInformation(int pageNum, int pageSize, String type, String path) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Information> page = fileMapper.getInformationByType(type);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return new Result().result200(pageResult, path);
    }

    /**
     * 返回指定id的资源路径
     * @param infoId
     * @return
     */
    @Override
    public String getInformationPath(String infoId) {
        return fileMapper.getInfoPathById(infoId);
    }


}
