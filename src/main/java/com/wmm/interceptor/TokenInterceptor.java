package com.wmm.interceptor;

import com.wmm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //0.放行OPTIONS预检请求（跨域时浏览器会先发OPTIONS请求，不带token）
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            return true;
        }
        //3.获取token
        String token = request.getHeader("token");
        //4.验证token是否为空
        if(token == null||token.isEmpty()){
            log.info("token为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //5.验证token是否有效
        try{
            Claims claims = JwtUtils.parseJwt(token);
        } catch (Exception e){
            log.info("token无效");
            return false;
        }
        //6.返回结果
        return true;
    }
}
