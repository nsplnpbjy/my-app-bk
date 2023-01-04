package com.bjy.myapp.controllers;

import com.bjy.myapp.exexception.AppException;
import com.bjy.myapp.sep.StanderReturnerPojo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public StanderReturnerPojo appException(AppException appException){
        return new StanderReturnerPojo(appException);
    }

}
