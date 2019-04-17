package com.example.sptest;

import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: linjx
 * Date: 2018/10/26
 */
public class TestUnit {

    @Test
    public void test1() throws Exception{
        Lock lock = new ReentrantLock();
        lock.lock();
        Condition condition = lock.newCondition();
        condition.awaitNanos(0);
        lock.unlock();
        System.err.println("-------------");
    }

    @Test
    public void test2() {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.getServletConfig();
    }

}
