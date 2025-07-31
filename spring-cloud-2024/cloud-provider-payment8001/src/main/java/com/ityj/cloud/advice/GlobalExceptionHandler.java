package com.ityj.cloud.advice;

import com.ityj.cloud.utils.ResultData;
import com.ityj.cloud.utils.ReturnCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResultData handleException(Exception e) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }

}
