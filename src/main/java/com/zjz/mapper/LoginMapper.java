package com.zjz.mapper;

import com.zjz.entity.dto.ForgetCipherDTO;
import com.zjz.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
     User getByUsername(String username);

     boolean saveUser(User user);

     boolean update(ForgetCipherDTO forgetCipherDTO);

    boolean updateUserInfo(User user);
}
