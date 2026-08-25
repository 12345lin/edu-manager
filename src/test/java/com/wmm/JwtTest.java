package com.wmm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /**
     * 测试jwt生成
     */
    @Test
    public void testJwt(){
        Map<String,Object> dateMap = new HashMap<>();
        dateMap.put("id",1);
        dateMap.put("username","wmm");
        dateMap.put("password","123456");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "d21teWhoaA==")
                .addClaims(dateMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000 * 2))
                .compact();
        System.out.println(jwt);

    }

    @Test
    public void testJwt2(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImlkIjoxLCJ1c2VybmFtZSI6IndtbSIsImV4cCI6MTc4MjMwMjE1N30.Da0l2pTV1QYpbMwQ6D9Y4o44t6FQ9Z_aQBzTTKExN1E";
        Claims body = Jwts.parser().setSigningKey("d21teWhoaA==")
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(body);
    }
}
