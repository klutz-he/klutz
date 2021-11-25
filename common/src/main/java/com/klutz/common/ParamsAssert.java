package com.klutz.common;

/**
 * 参数校验
 * created on 2021/11/25
 * @author klutz
 */
public abstract class ParamsAssert {

    public static void isNull( Object object, String message) {
        if (object != null) {
            throw new ParamsException(message);
        }
    }

    public static void isNull( Object object) {
        if (object != null) {
            throw new ParamsException();
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ParamsException(message);
        }
    }

    public static void isTrue(boolean expression) {
        if (!expression) {
            throw new ParamsException();
        }
    }
}
