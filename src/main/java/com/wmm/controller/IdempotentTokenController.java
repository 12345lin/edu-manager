package com.wmm.controller;

import com.wmm.interceptor.IdempotentInterceptor;
import com.wmm.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IdempotentTokenController {

    @GetMapping("/idempotent/token")
    public Result getToken() {
        String token = UUID.randomUUID().toString().replace("-", "");
        IdempotentInterceptor.putToken(token);
        return Result.success(token);
    }
}