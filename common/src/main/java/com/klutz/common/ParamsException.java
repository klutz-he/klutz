package com.klutz.common;

/**
 * created on 2021/11/24
 * @author klutz
 */
public class ParamsException extends BaseException {

    public ParamsException() {
        super(SystemErrorCodeEnum.PARAMS_ERROR);
    }

    public ParamsException(Throwable cause) {
        super(cause,SystemErrorCodeEnum.PARAMS_ERROR);
    }

    public ParamsException(String message) {
        super(SystemErrorCodeEnum.PARAMS_ERROR.getCode(),message);
    }

    public ParamsException(Throwable cause,String message) {
        super(cause,SystemErrorCodeEnum.PARAMS_ERROR.getCode(),message);
    }

}
