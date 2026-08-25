package com.wmm.interceptor;

import com.wmm.Exception.BizIllegalException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class IdempotentInterceptor implements HandlerInterceptor {

    private static final ConcurrentHashMap<String, Long> TOKEN_MAP = new ConcurrentHashMap<>();

    public static void putToken(String token) {
        TOKEN_MAP.put(token, System.currentTimeMillis());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String method = request.getMethod();
        if (!"POST".equalsIgnoreCase(method) && !"PUT".equalsIgnoreCase(method) && !"DELETE".equalsIgnoreCase(method)) {
            return true;
        }

        String token = request.getHeader("idempotent-token");
        if (token == null || token.isEmpty()) {
            throw new BizIllegalException("请勿重复提交");
        }

        Long timestamp = TOKEN_MAP.remove(token);
        if (timestamp == null) {
            throw new BizIllegalException("请勿重复提交");
        }

        if (System.currentTimeMillis() - timestamp > 5 * 60 * 1000) {
            throw new BizIllegalException("令牌已过期，请刷新页面重试");
        }

        return true;
    }
}