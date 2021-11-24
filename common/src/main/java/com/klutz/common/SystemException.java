package com.klutz.common;

/**
 * created on 2021/11/24
 * @author klutz
 */
public class SystemException extends BaseException {

    public SystemException(SystemErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    public SystemException(Throwable cause, SystemErrorCodeEnum errorCodeEnum) {
        super(cause,errorCodeEnum);
    }


}
