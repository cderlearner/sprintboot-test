package com.example.sptest.bean.service;

import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/29
 */
@Component
public class PartnerYJY extends Partner{

    @Override
    public String getOnlineAppId() {
        return "yjy";
    }

    @Override
    public String getSandboxAppId() {
        return "yjy";
    }
}
