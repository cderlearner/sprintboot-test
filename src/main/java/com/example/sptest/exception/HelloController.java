package com.example.sptest.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/json2")
    public String json2() throws MyException2 {
        throw new MyException2("发生错误2");
    }
}