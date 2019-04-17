package com.example.sptest.guava;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private DeadEventHandler deadEventHandler;

    @GetMapping("/")
    public void test() {
        deadEventHandler.post();
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
