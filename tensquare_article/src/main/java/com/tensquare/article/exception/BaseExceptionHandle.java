package com.tensquare.article.exception;


import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * service的也可以捕获
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandle {

    //value值表示捕获的异常类型，这里使用的是 Exception（所以异常父类），所以相当于捕获所有的异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        log.info("全局处理异常信息");
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
