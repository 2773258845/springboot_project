package com.example.common.result;

import com.example.common.enums.ResultCodeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义响应对象类：统一响应结果
 *      利用前4者可定义统一返回对象
 *
 * 1、是否响应成功
 * 2、响应状态码
 * 3、状态码描述
 * 4、响应数据
 * 5、其他标识符
 *
 * @author: Mr.Z
 * @create: 2020-04-17 19:48
 */
@Data
public class ResponseResult {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    // 构造器私有
    private ResponseResult() {
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    // 通用返回成功
    public static ResponseResult ok() {
        ResponseResult result = new ResponseResult();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }

    // 通用返回失败，未知错误
    public static ResponseResult error() {
        ResponseResult result = new ResponseResult();
        result.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        result.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        result.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return result;
    }

    // 设置结果，形参为结果枚举
    public static ResponseResult setResult(ResultCodeEnum resultCodeEnum) {
        ResponseResult result = new ResponseResult();
        result.setSuccess(result.getSuccess());
        result.setCode(result.getCode());
        result.setMessage(result.getMessage());
        return result;
    }

    /**------------使用链式编程，返回类本身-----------**/

    // 自定义返回数据
    public ResponseResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    // 通用设置data
    public ResponseResult data(String key,Object value) {
        this.data.put(key, value);
        return this;
    }

    // 自定义状态信息
    public ResponseResult message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public ResponseResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public ResponseResult success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}
