package com.zjz.service.impl;

import com.zjz.entity.dto.ForgetCipherDTO;
import com.zjz.entity.dto.LoginUserDTO;
import com.zjz.entity.dto.RegisterUserDTO;
import com.zjz.entity.po.User;
import com.zjz.mapper.LoginMapper;
import com.zjz.service.UserLoginService;
import com.zjz.untils.BeansUtils;
import com.zjz.untils.JwtUtils;
import com.zjz.untils.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 注册
     * @param registerUserDTO
     * @param path
     * @return
     */
    @Override
    public Result registerUser(RegisterUserDTO registerUserDTO, String path) {
        //拷贝UserDTO里面的属性到User并进行属性增加
        User user = BeansUtils.beanCopy(registerUserDTO,User.class);
        //查询用户名是否已注册
        if (loginMapper.getByUsername(user.getUsername()) != null){
            return new Result().result403("该用户名已经被注册",path);
        }
        user.setRole("1");
        //user.setId(UUID.randomUUID().toString());
        //对于用户进行存储
        if (!loginMapper.saveUser(user)) {
            return new Result().result500("用户注册失败",path);
        }
        return new Result().result200("注册成功",path);
    }

    /**
     * 修改密码
     * @param forgetCipherDTO
     * @param path
     * @return
     */
    @Override
    public Result forgetCipher(ForgetCipherDTO forgetCipherDTO, String path) {
        //通过用户名查找对应的用户
        User user = loginMapper.getByUsername(forgetCipherDTO.getUsername());
        //判断有无该用户
        if(user == null){
            return new Result().result404("修改密码失败，用户名或密码错误",path);
        }
        //判断前后密码是否一致
        if(!forgetCipherDTO.getNewOnePassword().equals(forgetCipherDTO.getNewTwoPassword())){
            return new Result().result500("前后两次密码不相同，请重新输入",path);
        }
        //判断旧密码是否正确
        if (user.getPassword().equals(forgetCipherDTO.getOldPassword()) ){
            loginMapper.update(forgetCipherDTO);
            return new Result().result200("密码修改成功",path);
        }else {
            return new Result().result404("密码修改失败，用户名或密码不正确",path);
        }


    }

    /**
     * 登录
     * @param loginUserDTO
     * @param path
     * @return
     */
    @Override
    public Result loginUser(LoginUserDTO loginUserDTO, String path) {
        //查询有无该用户
        User user = loginMapper.getByUsername(loginUserDTO.getUsername());
        if(user == null){
            return new Result().result404("登陆失败",path);
        }
        if (loginUserDTO.getPassword().equals(user.getPassword())){
            //设置token,token中存储用户的基本信息
            Map<String, Object> mapUser = new HashMap<>();
            mapUser.put("id", user.getUserId());
            mapUser.put("username", user.getUsername());
            mapUser.put("role", user.getRole());
            String token = JwtUtils.generateToken(mapUser);
            //将用户的信息存入redis
            redisTemplate.opsForValue().set(token,user,7, TimeUnit.DAYS);
            //将token返回
            Map<String, Object> map = new HashMap<>(2);
            map.put("message","登录成功");
            map.put("token",token);
            map.put("roleName",user.getRole());
            map.put("username",user.getUsername());
            return new Result().result200(map,path);
        }else {
            return new Result().result404("登陆失败",path);
        }

    }
}
