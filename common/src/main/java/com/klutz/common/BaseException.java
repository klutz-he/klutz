package com.klutz.common;

/**
 * created on 2021/11/24
 * @author klutz
 */
public class BaseException extends RuntimeException{

    private final int code;

    public BaseException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(Throwable cause, ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage(),cause);
        this.code = errorCodeEnum.getCode();
    }

    public BaseException(Throwable cause, int code, String message) {
        super(message,cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
