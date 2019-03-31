package com.example.sptest.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@RestController
@SpringBootApplication
public class ZMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZMain.class, args);
        //context.getEnvironment().addActiveProfile("jd-testing");
    }

    @Autowired
    private Hello hello;
    @Autowired
    private JDCipherConfig jdCipherConfig;
    @Autowired
    private JDConfig jdConfig;
    @Autowired
    private JDKmopen jdKmopen;
    @Autowired
    private ApplicationContext applicationContext;

    private Set<String> profiles = Collections.emptySet();

    @PostConstruct
    protected void init() {
        profiles = Stream.of(applicationContext.getEnvironment().getActiveProfiles()).collect(Collectors.toSet());
    }

    @GetMapping("/")
    public void test() {
        hello.hi();
        System.err.println(jdCipherConfig);
        System.err.println(jdConfig);
        System.err.println(jdKmopen);

//        Set<String> stringSet = Stream.of(applicationContext.getEnvironment().getActiveProfiles()).collect(Collectors.toSet());
//        System.out.println(stringSet);
//        if (stringSet.contains("jd-testing")) {
//            System.out.println("profile:" + " jd-testing");
//        }
        System.out.println("profiles: " + profiles);
    }
}
