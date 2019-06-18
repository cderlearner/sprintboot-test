package com.example.sptest.aop;

import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/6/16
 */
@Component
public class TestBean implements TestBeanI{

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }

}
