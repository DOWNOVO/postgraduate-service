package com.zjz.untils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private static String signKey = "itheima";

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
    public static String generateToken(Map<String, Object> claims){
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(signKey));
    }

    /**
     * 解析JWT令牌
     * @param token JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(signKey))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}