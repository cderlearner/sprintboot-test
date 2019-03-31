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
        return "1";
    }

    @Override
    public String getSandboxAppId() {
        return null;
    }
}
