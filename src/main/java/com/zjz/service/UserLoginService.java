package com.zjz.service;

import com.zjz.entity.dto.ForgetCipherDTO;
import com.zjz.entity.dto.LoginUserDTO;
import com.zjz.entity.dto.RegisterUserDTO;
import com.zjz.untils.Result;

public interface UserLoginService {
    public Result registerUser(RegisterUserDTO registerUserDTO, String path);

    Result forgetCipher(ForgetCipherDTO forgetCipherDTO, String path);

    Result loginUser(LoginUserDTO loginUserDTO, String path);
}
