package com.zjz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zjz.mapper")
public class ZjzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjzApplication.class, args);
    }

}
