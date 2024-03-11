package com.zjz.service.impl;


import com.zjz.entity.po.User;
import com.zjz.mapper.RoleMapper;
import com.zjz.service.RoleService;
import com.zjz.untils.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
//    @Override
//    public String getByRoleName(String name) {
//        return roleMapper.getByName(name);
//    }

    @Override
    public Result getByUsers(String token, String path) {
        //设置方法的允许权限
        List<String> list = new ArrayList<>();
        list.add("user");
        if (!this.getByAuthorization(token, list)) {
            return new Result().result403("没有权限",path);
        }
        return null;
    }

    public Boolean getByAuthorization(String token, List<String> authorization) {
        //通过token获取用户的具体信息
        User user = (User) redisTemplate.opsForValue().get(token);
        //判断取出的用户信息是否可用
        if (user == null){
            return false;
        }
        //判断权限是否可用
        for (String roleName : authorization){
            if (user.getRole().equals(roleName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Result getByAdminOrUsers(String token, String path) {
        //设置方法的允许权限
        List<String> list = new ArrayList<>();
        list.add("user");
        list.add("admin");
        if (!this.getByAuthorization(token, list)) {
            return new Result().result403("没有权限",path);
        }
        return null;
    }

    @Override
    public Result getByAdmin(String token, String path) {
        //设置方法的允许权限
        List<String> list = new ArrayList<>();
        list.add("admin");
        if (!this.getByAuthorization(token, list)) {
            return new Result().result403("没有权限",path);
        }
        return null;
    }
}
