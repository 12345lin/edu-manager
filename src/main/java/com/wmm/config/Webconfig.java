package com.wmm.config;

import com.wmm.interceptor.DemoIntercepter;
import com.wmm.interceptor.IdempotentInterceptor;
import com.wmm.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Webconfig implements WebMvcConfigurer {
//    @Autowired
//    private DemoIntercepter demoIntercepter;

    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Autowired
    private IdempotentInterceptor idempotentInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login", "/idempotent/token", "/login.html", "/images/**");//放行登录接口、幂等Token获取和登录页静态资源
        registry.addInterceptor(idempotentInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}