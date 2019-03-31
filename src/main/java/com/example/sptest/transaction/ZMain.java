package com.example.sptest.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@RestController
@SpringBootApplication
public class ZMain {

    public static void main(String[] args) {
        SpringApplication.run(ZMain.class, args);
    }


    
    @GetMapping("/")
    public void test() {

    }
}
