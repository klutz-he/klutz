package com.klutz.common;

/**
 * created on 2021/11/24
 * @author klutz
 */
public interface ErrorCodeEnum {

    int getCode();

    String getMsg();

    /**
     * 抛出异常
     */
    void failThrow( );

}
