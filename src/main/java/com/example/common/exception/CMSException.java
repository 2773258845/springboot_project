package com.example.common.exception;

import com.example.common.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * 自定义全局异常类
 * @author: Mr.Z
 * @create: 2020-04-17 19:58
 */
@Getter
public class CMSException extends RuntimeException {

    private Integer code;

    public CMSException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CMSException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
