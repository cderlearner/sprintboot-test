package com.example.sptest.bean.default_test;

/**
 * Author: linjx
 * Date: 2019/4/10
 */
public interface VipService {

    default boolean isBannedByZhihu(long memberId, String phone, String ip) {
        return getZhihuBanInfo(memberId, phone, ip) != null;
    }

    default String getZhihuBanInfo(long memberId, String phone, String ip) {
        return null;
    }
}
