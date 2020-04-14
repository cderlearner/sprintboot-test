package com.example.sptest;

import org.apache.commons.lang3.StringUtils;

public enum RedisKeyEnum {

    /**
     * 官方账号粉丝列表 随机缓存
     * key-Value 结构
     * key: followers
     * itemKey: userId:page
     * itemValue: ucUserList->json  一页20个user对象
     */
    FOLLOWERS("followers:page", true, 2 * 60 * 60),   // 单位秒

    /**
     * 官方账号粉丝列表 随机缓存分布式锁
     * Key-Value 结构
     * key: followers:lock
     * itemKey: userId:page
     * itemValue: 1
     */
    FOLLOWERS_LOCK("followers:lock", true, 2),

    DAU_SYNC_FIRST("dau_sync_first", false, 24 * 60 * 60),
    ;

    public static final char KEY_SEP = ':';

    private String key;
    private boolean plain;     // 是否为普通key，不是普通key不拼接itemKey
    private int timeout = -1; // 过期时间,单位秒

    RedisKeyEnum(String key, boolean plain) {
        this.key = key;
        this.plain = plain;
    }

    RedisKeyEnum(String key, boolean plain, int timeout) {
        this.key = key;
        this.plain = plain;
        this.timeout = timeout;
    }

    public String getKey() {
        return key;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getItemKey(Object... params) {
        String itemKey = StringUtils.join(params, KEY_SEP);
        if (!plain) { // hash item key, no prefix
            return itemKey;
        }
        return key + KEY_SEP + itemKey;
    }

    public String getItemKey(String keySep, Object... params) {
        String itemKey = StringUtils.join(params, keySep);
        if (!plain) {
            return itemKey;
        }
        return key + keySep + itemKey;
    }

    public static void main(String[] args) {
        String itemKey = RedisKeyEnum.DAU_SYNC_FIRST.getItemKey("_", 11l,  "2020-11-11");
        System.out.println(itemKey);
    }

}
