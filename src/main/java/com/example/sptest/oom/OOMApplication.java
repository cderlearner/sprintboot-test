package com.example.sptest.oom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class OOMApplication implements CommandLineRunner {

    @Autowired
    FooService fooService;

    public static void main(String[] args) {
        SpringApplication.run(OOMApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //程序启动后，不断调用Fooservice.oom()方法
        while (true) {
            fooService.oom();
        }
    }

    @Component
    public class FooService {
        List<String> data = new ArrayList<>();

        public void oom() {
            //往同一个ArrayList中不断加入大小为10KB的字符串
            data.add(IntStream.rangeClosed(1, 10_000)
                    .mapToObj(__ -> "a")
                    .collect(Collectors.joining()));
        }
    }
}
