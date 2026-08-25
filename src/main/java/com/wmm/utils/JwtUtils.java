package com.wmm.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT令牌操作工具类
 */
public class JwtUtils {

    // 签名密钥（与测试类保持一致）
    private static final String SIGN_KEY = "d21teWhoaA==";

    /**
     * 生成JWT令牌
     * @param claims 自定义声明数据
     * @return JWT令牌字符串
     */
    public static String generateJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)
                .addClaims(claims) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000 * 12)) // 设置过期时间为12小时
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌字符串
     * @return Claims对象，包含令牌中的所有声明
     */
    public static Claims parseJwt(String jwt) {
        Claims body = Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return body;
    }
}
