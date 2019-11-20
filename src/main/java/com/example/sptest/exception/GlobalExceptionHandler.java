package com.example.sptest.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());

        System.out.println("myEx:-----------------");
        return r;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> errorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());

        System.out.println("ex:-----------------");
        return r;
    }

//    @ExceptionHandler
//    @ResponseBody
//    public ErrorInfo<String> errorHandler2(Exception ex, HttpServletRequest req, MyException e) throws Exception {
//        ErrorInfo<String> r = new ErrorInfo<>();
//        r.setMessage(e.getMessage());
//        r.setCode(ErrorInfo.ERROR);
//        r.setData("Some Data");
//        r.setUrl(req.getRequestURL().toString());
//
//        System.out.println("myEx2:-----------------");
//        return r;
//    }
}
