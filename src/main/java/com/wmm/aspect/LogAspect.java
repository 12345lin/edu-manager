package com.wmm.aspect;

import com.alibaba.fastjson.JSONObject;
import com.wmm.anno.Log;
import com.wmm.pojo.OperateLog;
import com.wmm.service.OperateLogService;
import com.wmm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 操作日志切面类
 * 拦截所有带有 @Log 注解的方法，记录操作日志
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private OperateLogService operateLogService;

    /**
     * 定义切入点：匹配 controller 包下所有类的增删改方法
     * 以及所有带有 @Log 注解的方法
     */
    @Pointcut("@annotation(com.wmm.anno.Log)")
    public void logPointCut() {
    }

    /**
     * 环绕通知：在目标方法执行前后记录日志
     * @param joinPoint 连接点
     * @return 目标方法的返回值
     * @throws Throwable 异常
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取开始时间
        long beginTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 获取结束时间
        long endTime = System.currentTimeMillis();

        // 计算耗时（毫秒）
        long costTime = endTime - beginTime;

        // 记录操作日志
        try {
            saveLog(joinPoint, costTime, result);
        } catch (Exception e) {
            // 日志记录失败不影响业务逻辑
            log.error("记录操作日志失败", e);
        }

        return result;
    }

    /**
     * 保存操作日志
     * @param joinPoint 连接点
     * @param costTime 耗时
     * @param result 返回值
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long costTime, Object result) {
        // 获取 HttpServletRequest
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        // 从请求中获取当前登录用户ID（假设已存储在 session 或 header 中）
        Integer operateEmpId = getCurrentUserId(request);
        if (operateEmpId == null) {
            // 如果无法获取用户ID，使用默认值 0
            operateEmpId = 0;
        }

        // 构建操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(operateEmpId);
        operateLog.setOperateTime(LocalDateTime.now());
        
        // 获取目标类的全类名
        String className = joinPoint.getTarget().getClass().getName();
        operateLog.setClassName(className);
        
        // 获取目标方法名
        String methodName = joinPoint.getSignature().getName();
        operateLog.setMethodName(methodName);
        
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 限制参数长度，避免过长
        if (methodParams.length() > 2000) {
            methodParams = methodParams.substring(0, 2000);
        }
        operateLog.setMethodParams(methodParams);
        
        // 获取返回值
        String returnValue = JSONObject.toJSONString(result);
        // 限制返回值长度，避免过长
        if (returnValue.length() > 2000) {
            returnValue = returnValue.substring(0, 2000);
        }
        operateLog.setReturnValue(returnValue);
        
        // 设置耗时
        operateLog.setCostTime(costTime);

        // 调用 Service 保存日志
        operateLogService.insert(operateLog);
        
        log.info("操作日志记录成功: {}.{}, 耗时: {}ms", className, methodName, costTime);
    }

    /**
     * 获取当前登录用户ID
     * @param request HTTP 请求
     * @return 用户ID，如果未登录返回 null
     */
    private Integer getCurrentUserId(HttpServletRequest request) {
        // 从请求头中获取 token（与 TokenInterceptor 保持一致）
        String token = request.getHeader("token");
        
        if (token == null || token.isEmpty()) {
            log.warn("请求头中未找到token");
            return null;
        }

        try {
            // 解析 token，获取用户ID
            Claims claims = JwtUtils.parseJwt(token);
            Object id = claims.get("id");
            
            if (id != null) {
                return (Integer) id;
            }
        } catch (Exception e) {
            log.error("解析token失败", e);
        }

        return null;
    }
}
