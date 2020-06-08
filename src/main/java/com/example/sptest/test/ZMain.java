package com.example.sptest.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZMain {

    public static void main(String[] args) {
        SpringApplication.run(ZMain.class, args);
    }
}
