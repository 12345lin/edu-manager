package com.wmm.filter;

import com.wmm.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1获取请求路径
        String path = request.getRequestURI();
        //2.判断是否是登陆请求。如果包含/login，就放行
        if(path.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        //3.获取token
        String token = request.getHeader("token");
        //4.判断token是否为空，如果为空，就返回错误信息
        if(token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"token不能为空\"}");
            return;
        }
        //5.判断token是否正确，如果正确，就放行，否则返回错误信息
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.error("token解析错误：{}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"token无效或已过期\"}");
            return;
        }
        //6.放行
        filterChain.doFilter(request, response);
    }
}
