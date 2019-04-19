package com.example.sptest.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@RestController
@EnableRetry
@EnableAsync
@SpringBootApplication
public class ZMain {

    public static void main(String[] args) {
        SpringApplication.run(ZMain.class, args);
    }

    @Autowired
    private RetryService retryService;

    @GetMapping("/")
    public void test() {
        retryService.test();
    }

    @GetMapping("/j")
    public String test2() {
        return "<{\"data\":true,\"status\":true}";
    }
}
