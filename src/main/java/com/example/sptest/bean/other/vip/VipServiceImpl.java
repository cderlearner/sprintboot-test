package com.example.sptest.bean.other.vip;

import org.springframework.stereotype.Service;

/**
 * Author: linjx
 * Date: 2019/4/4
 */
@Service
public class VipServiceImpl implements VipService {

    @Override
    public void oneClickPlaceOrder(long memberId, String skuId) {
        System.out.println("memberId");
    }

    public static void main(String[] args) {
        VipService vipService = new VipServiceImpl();
        vipService.oneClickPlaceOrder(1 , "1");
        vipService.oneClickPlaceOrder("2", "1");
    }
}
