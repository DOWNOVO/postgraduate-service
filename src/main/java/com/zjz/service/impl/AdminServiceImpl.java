package com.zjz.service.impl;

import com.zjz.entity.po.Admission;
import com.zjz.entity.po.GeneralRegulations;
import com.zjz.mapper.AdminMapper;
import com.zjz.service.AdminService;
import com.zjz.untils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 删除录取信息
     * @param admissionId
     * @param path
     * @return
     */
    @Override
    public Result deleteAdmission(String admissionId, String path) {
        adminMapper.deleteAdmissionById(admissionId);
        return new Result().result200("删除成功",path);
    }

    /**
     * 更新录取信息
     * @param admission
     * @param path
     * @return
     */
    @Override
    public Result updateAdmission(Admission admission, String path) {
        adminMapper.updateAdmission(admission);
        return new Result().result200("更新成功", path);
    }

    /**
     * 插入添加录取信息
     * @param admission
     * @param path
     * @return
     */
    @Override
    public Result insertAdmission(Admission admission, String path) {
        admission.setAdmissionId(UUID.randomUUID().toString());
        admission.setAddedTime(System.currentTimeMillis());
        adminMapper.insertAdmission(admission);
        return new Result().result200("添加成功", path);
    }

    /**
     * 删除资料
     * @param informationId
     * @param path
     * @return
     */
    @Override
    public Result deleteInformation(String informationId, String path) {
        adminMapper.deleteInformation(informationId);
        return new Result().result200("删除成功",path);
    }

    /**
     * 删除招生简章
     * @param generalRegulationsId
     * @param path
     * @return
     */
    @Override
    public Result deleteGeneralRegulations(String generalRegulationsId, String path) {
        adminMapper.deleteGeneralRegulations(generalRegulationsId);
        return new Result().result200("删除成功",path);
    }

    /**
     * 添加招生简章
     * @param generalRegulations
     * @param path
     * @return
     */
    @Override
    public Result insertGeneralRegulations(GeneralRegulations generalRegulations, String path) {
        adminMapper.insertGeneralRegulations(generalRegulations);
        return new Result().result200("添加成功", path);
    }

    /**
     * 更新招生简章
     * @param generalRegulations
     * @param path
     * @return
     */
    @Override
    public Result updateGeneralRegulations(GeneralRegulations generalRegulations, String path) {
        adminMapper.updateGeneralRegulations(generalRegulations);
        return new Result().result200("更新成功",path);
    }

    /**
     * 删除用户
     * @param username
     * @param path
     * @return
     */
    @Override
    public Result deleteUser(String username, String path) {
        adminMapper.deleteUser(username);
        return new Result().result200("删除用户成功",path);
    }
}
