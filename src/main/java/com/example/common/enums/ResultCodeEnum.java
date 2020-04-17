package com.example.common.enums;

import lombok.Getter;

/**
 * 自定义响应枚举类
 * @author: Mr.Z
 * @create: 2020-04-17 20:22
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true,1000, "请求成功!"),
    PARAMETER_ERROR(false,1001, "请求参数有误!"),
    NULL_POINT(false,1002,"空指针异常!"),
    HTTP_CLIENT_ERROR(false,1002,"Http客户端异常!"),
    UNKNOWN_ERROR(false,9999, "未知的错误!")
    ;

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
