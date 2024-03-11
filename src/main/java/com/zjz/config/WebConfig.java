package com.zjz.config;

import com.zjz.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置/user/login 路径可以跳过拦截器，后面需要修改，因为有很多页面不用登录，
        // 不用验证token也可以查看
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/loginUser");
    }
}
