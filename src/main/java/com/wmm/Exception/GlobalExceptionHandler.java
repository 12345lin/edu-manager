package com.wmm.Exception;

import com.wmm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import java.net.BindException;
import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 1. 数据库唯一键冲突异常（如：用户名重复）
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("数据重复错误：{}", e.getMessage());

        String message = e.getMessage();
        if (message != null && message.contains("emp.username")) {
            return Result.error("用户名已存在，请使用其他用户名");
        } else if (message != null && message.contains("dept.name")) {
            return Result.error("部门名称已存在，请使用其他名称");
        }
        return Result.error("数据已存在，请勿重复添加");
    }

    /**
     * 2. JSON 解析异常（前端传参格式错误）
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleJsonParseException(HttpMessageNotReadableException e) {
        log.error("JSON解析错误：{}", e.getMessage());
        return Result.error("请求数据格式错误，请检查JSON格式是否正确");
    }

    /**
     * 3. 参数校验异常（@Valid/@Validated 校验失败）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationException(MethodArgumentNotValidException e) {
        log.error("参数校验错误：{}", e.getMessage());
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("参数校验失败");
        return Result.error(message);
    }

    /**
     * 4. 绑定异常（表单数据绑定失败）
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        log.error("数据绑定错误：{}", e.getMessage());
        return Result.error("参数绑定失败，请检查参数格式");
    }

    /**
     * 5. 缺少必需的路径参数异常
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public Result handleMissingPathVariableException(MissingPathVariableException e) {
        log.error("缺少路径参数：{}", e.getMessage());
        return Result.error("缺少必需的路径参数：" + e.getVariableName());
    }

    /**
     * 6. 缺少必需的请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数：{}", e.getMessage());
        return Result.error("缺少必需参数：" + e.getParameterName());
    }

    /**
     * 7. 参数类型不匹配异常（如：字符串转整数失败）
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result handleTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("参数类型错误：参数名={}, 期望类型={}, 实际值={}",
                e.getName(), e.getRequiredType(), e.getValue());
        return Result.error("参数格式错误：" + e.getName());
    }

    /**
     * 8. 文件上传大小超限异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error("文件上传大小超限：{}", e.getMessage());
        return Result.error("文件大小超过限制，请上传更小的文件");
    }

    /**
     * 9. 文件上传异常
     */
    @ExceptionHandler(MultipartException.class)
    public Result handleMultipartException(MultipartException e) {
        log.error("文件上传错误：{}", e.getMessage());
        return Result.error("文件上传失败，请重试");
    }

    /**
     * 10. SQL 异常
     */
    @ExceptionHandler(SQLException.class)
    public Result handleSQLException(SQLException e) {
        log.error("数据库SQL错误：{}", e.getMessage());
        return Result.error("数据库操作失败，请联系管理员");
    }

    /**
     * 11. 业务异常（如：重复提交）
     */
    @ExceptionHandler(BizIllegalException.class)
    public Result handleBizIllegalException(BizIllegalException e) {
        log.warn("业务异常：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 12. 运行时异常（捕获所有未明确处理的异常）
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        log.error("运行时异常：", e);
        return Result.error("系统运行错误，请稍后重试");
    }

    /**
     * 13. 通用异常（兜底处理，捕获所有其他异常）
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统异常：", e);
        return Result.error("系统错误，请联系管理员");
    }
}