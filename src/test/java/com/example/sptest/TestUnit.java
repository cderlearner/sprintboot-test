package com.example.sptest;

import com.example.sptest.bean.dto.YJYRefundOrderRes;
import com.example.sptest.okhttp.OkHttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    @Test
    public void test3() {
        YJYRefundOrderRes res = null;
        System.out.println(res instanceof YJYRefundOrderRes);

        res = null;
        System.err.println(res instanceof YJYRefundOrderRes);
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test4() throws IOException {
        String json = "<{\"data\":true,\"status\":true}";

        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toString());
    }

    @Test
    public void test5() {
        Request req = new Request
                .Builder()
                .url("http://localhost:8080/j")
                .get()
                .build();
        JsonNode jsonNode = OkHttpUtil.doRequest(req);
        System.out.println(jsonNode);
    }

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
        System.out.println(!CollectionUtils.isEmpty(Collections.emptyList()));
        System.out.println(!CollectionUtils.isEmpty(Arrays.asList(1)));

    }
}
