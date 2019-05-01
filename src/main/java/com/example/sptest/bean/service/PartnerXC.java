package com.example.sptest.bean.service;

import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/4/8
 */
@Component
public class PartnerXC extends Partner{

    @Override
    public String getOnlineAppId() {
        return "xc";
    }

    @Override
    public String getSandboxAppId() {
        return "xc";
    }
}
