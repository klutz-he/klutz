package com.klutz.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * created on 2021/11/23
 * @author klutz
 */
public class CommonResponse<T> {

    private static final int SUCCESS_CODE = 0;

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return code == 0;
    }

    public static <T>  CommonResponse<T> ok( ){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setCode(SUCCESS_CODE);
        commonResponse.setMessage("");
        return commonResponse;
    }

    public static <T>  CommonResponse<T> ok( T data ){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setCode(SUCCESS_CODE);
        commonResponse.setMessage("");
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T>  CommonResponse<T> fail( Integer code,String msg ){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setCode(code);
        commonResponse.setMessage(msg);
        return commonResponse;
    }


}
