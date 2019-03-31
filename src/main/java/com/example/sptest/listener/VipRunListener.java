package com.example.sptest.listener;

import com.example.sptest.listener.event.MemberCreateByPhoneNoEvent;
import com.example.sptest.listener.event.MemberCreateByPhoneNoMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VipRunListener implements SpringApplicationRunListener {
    private SpringApplication app;
    private List<String> args;

    public VipRunListener(SpringApplication app, String... args) {
        this.app = app;
        this.args = Arrays.asList(args);
    }

    @Override
    public void starting() {
        List<String> additionalProfiles = new LinkedList<>();
        additionalProfiles.add("jd-testing");
        app.setAdditionalProfiles(additionalProfiles.toArray(new String[0]));
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment env) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("当前线程：" + Thread.currentThread().getName());

        MemberCreateByPhoneNoMessage msg = new MemberCreateByPhoneNoMessage();
        msg.setUserName("ljx");
        context.publishEvent(new MemberCreateByPhoneNoEvent(this, msg));
    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
