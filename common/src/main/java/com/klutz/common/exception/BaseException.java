package com.klutz.common.exception;

import com.klutz.common.ErrorCodeEnum;

/**
 * created on 2021/11/24
 * @author klutz
 */
public class BaseException extends RuntimeException{

    private final ErrorCodeEnum errorCodeEnum;

    public BaseException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
    }

    public BaseException(Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(cause);
        this.errorCodeEnum = errorCodeEnum;
    }

    public String getMsg( ){
        return errorCodeEnum.getMsg();
    }

}
