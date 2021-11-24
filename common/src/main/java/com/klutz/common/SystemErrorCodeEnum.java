package com.klutz.common;

import com.klutz.common.exception.SystemException;

/**
 * created on 2021/11/24
 * @author klutz
 */
public enum SystemErrorCodeEnum implements ErrorCodeEnum{

    SYSTEM_ERROR(1000001,"系统错误");

    private final int code;

    private final String msg;

    SystemErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void failThrow() {
        throw new SystemException(this);
    }


}
