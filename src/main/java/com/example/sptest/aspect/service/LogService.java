package com.example.sptest.aspect.service;

import com.example.sptest.aspect.LogEvent;
import com.example.sptest.bean.dto.OrderCreateRequest;
import com.example.sptest.bean.dto.OrderCreateResponse;
import org.springframework.stereotype.Service;

/**
 * Author: linjx
 * Date: 2019/4/8
 */
@Service
public class LogService {

    @LogEvent
    public OrderCreateResponse foo(OrderCreateRequest param) {
        System.out.println(param.toJson());
        return OrderCreateResponse.builder().buyDays(1).mobile("+86").status("sucess").build();
    }
}
