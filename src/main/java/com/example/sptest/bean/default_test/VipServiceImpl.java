package com.example.sptest.bean.default_test;

/**
 * Author: linjx
 * Date: 2019/4/10
 */
public class VipServiceImpl implements VipService{

    @Override
    public String getZhihuBanInfo(long memberId, String phone, String ip) {
        return "vip:" + memberId + phone + ip;
    }

    public static void main(String[] args) {
        VipService vipService = new VipServiceImpl();
        System.out.println(vipService.isBannedByZhihu(1, "13", "1.1.1.1"));
        System.out.println(vipService.getZhihuBanInfo(1, "13", "1.1.1.1"));
    }
}
