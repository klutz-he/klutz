package com.klutz.common;

/**
 * created on 2021/11/24
 * @author klutz
 */
public enum SystemErrorCodeEnum implements ErrorCodeEnum{

    SYSTEM_ERROR(1000001,"系统错误"),
    PARAMS_ERROR(1000002,"参数错误")
    ;

    private final int code;

    private final String message;

    SystemErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void failThrow() {
        throw new SystemException(this);
    }


}
