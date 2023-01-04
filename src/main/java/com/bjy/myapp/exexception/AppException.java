package com.bjy.myapp.exexception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends Exception{
    private String msg;
    private Integer code;
}
