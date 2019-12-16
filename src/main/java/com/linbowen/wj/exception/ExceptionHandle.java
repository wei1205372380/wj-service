package com.linbowen.wj.exception;

import com.linbowen.wj.result.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理全局的异常
 */
@ControllerAdvice
@RestController
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleException(Exception e) {
        e.printStackTrace();
//        System.out.println(e.printStackTrace());
        return BaseResponse.buildFail("系统异常");
    }

}
