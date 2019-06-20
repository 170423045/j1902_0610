package com.luochuan.j1902_0610.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String defaultErrorHandle(HttpServletRequest request,Exception e){
        return "unauth";
    }
}
