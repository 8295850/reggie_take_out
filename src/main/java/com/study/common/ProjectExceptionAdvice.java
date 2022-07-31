package com.study.common;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 异常处理类
 * 需要保证SpringMvc 能扫描到
 * 普通风格
 *
 * @ControllerAdvice
 */
//REST风格
@RestControllerAdvice
public class ProjectExceptionAdvice {
//    //系统异常
//    @ExceptionHandler(SystemException.class)
//    public Result DoException(SystemException e){
//        System.out.println("系统异常");
//
//        return new Result(e.getCode(),null,e.getMessage());
//    }
    //业务异常
    @ExceptionHandler(BusinessException.class)
    public R<String> DoException(BusinessException e){
        System.out.println("业务异常");
        return  R.error(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> DoException(SQLIntegrityConstraintViolationException e) {

        if (e.getMessage().contains("Duplicate entry")) {
            String message = e.getMessage();
            String[] s = message.split(" ");
            return R.error(s[2] + "已存在");
        }
        return R.error(e.getMessage()+"，请联系管理员");
    }
    //其他异常
//    @ExceptionHandler(Exception.class)
//    public R DoException(Exception e){
//        System.out.println("出现异常，请排查...");
//        return R.error("出现异常，请联系管理员...");
//    }


}
