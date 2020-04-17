package com.example.common.exception;

import com.example.common.enums.ResultCodeEnum;
import com.example.common.result.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 统一异常处理器
 * @author: Mr.Z
 * @create: 2020-04-17 19:57
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**-------- 通用异常处理方法 --------**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult error(Exception e) {
        e.printStackTrace();
        return ResponseResult.error();
    }

    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseResult error(NullPointerException e) {
        e.printStackTrace();
        return ResponseResult.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseResult error(IndexOutOfBoundsException e) {
        e.printStackTrace();
        return ResponseResult.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**-------- 自定义定异常处理方法 --------**/
    public ResponseResult error(CMSException e) {
        e.printStackTrace();
        return ResponseResult.error().message(e.getMessage()).code(e.getCode());
    }
}
