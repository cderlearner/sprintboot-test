package com.example.sptest.bean.other.vip;

/**
 * Author: linjx
 * Date: 2019/4/4
 */
public interface VipService {

    /**
     * 一键领取 合作方联名卡 权益
     */
    default void oneClickPlaceOrder(long memberId, String skuId) {
    }

    default void oneClickPlaceOrder(String phone, String skuId) {
        System.out.println(phone);
    }
}
