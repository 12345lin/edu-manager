package com.wmm.controller;

import com.wmm.pojo.Emp;
import com.wmm.pojo.LoginInfo;
import com.wmm.pojo.Result;
import com.wmm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("登录：{}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo == null){
            return Result.error("登录失败,用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
