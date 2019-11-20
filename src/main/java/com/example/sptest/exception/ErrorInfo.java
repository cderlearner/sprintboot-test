package com.example.sptest.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

    // 省略getter和setter

}