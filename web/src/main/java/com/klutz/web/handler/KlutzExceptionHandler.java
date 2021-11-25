package com.klutz.web.handler;

import com.klutz.common.BaseException;
import com.klutz.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常拦截
 * created on 2021/10/19
 * @author klutz
 */
@Slf4j
@ControllerAdvice
@SuppressWarnings("rawtypes")
public class KlutzExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public CommonResponse handleBaseException(BaseException baseException){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(baseException.getCode());
        commonResponse.setMessage(baseException.getMessage());
        return commonResponse;
    }

}
