package com.yb.exception;


import com.alibaba.fastjson.JSON;
import com.yb.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error("服务器异常，稍后重试={},", request.getRequestURL(), exception);
        return CommonResult.error("服务器异常，稍后重试");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<String> methodNotSupportHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        log.error("不支持的请求方法={},", request.getRequestURL(), e);
        return CommonResult.error("不支持的请求方法");
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return CommonResult.error(message);
    }

    /**
     * 业务异常
     * @param request
     * @param serviceException
     * @return
     */
    @ExceptionHandler(value = {ServiceException.class})
    public CommonResult<?> serviceExceptionHandler(HttpServletRequest request, ServiceException serviceException) {
        CommonResult<?> message = new CommonResult<>(serviceException.getCode(), serviceException.getMsg(), null);
        log.error("exception message",serviceException);
        log.error("业务异常={},接口响应={}", request.getRequestURL(), JSON.toJSONString(message));
        return message;
    }


}
