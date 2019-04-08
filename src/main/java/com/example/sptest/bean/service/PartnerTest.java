package com.example.sptest.bean.service;

import com.example.sptest.bean.dto.CanOpenRequest;
import com.example.sptest.bean.dto.CanOpenResponse;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/4/3
 */
@Component
public class PartnerTest extends Partner{
    @Override
    public CanOpenResponse canOpen(CanOpenRequest request) {
        System.out.println("hello wolrd !");
        return super.canOpen(request);
    }

    @Override
    public String getOnlineAppId() {
        return "test";
    }

    @Override
    public String getSandboxAppId() {
        return "test";
    }
}
