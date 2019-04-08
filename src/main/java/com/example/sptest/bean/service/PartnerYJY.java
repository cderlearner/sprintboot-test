package com.example.sptest.bean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/29
 */
@Component
public class PartnerYJY extends Partner{
    @Autowired
    private PartnerXC partnerXC;

    @Override
    public String getOnlineAppId() {
        return "yjy";
    }

    @Override
    public String getSandboxAppId() {
        return "yjy";
    }
}
