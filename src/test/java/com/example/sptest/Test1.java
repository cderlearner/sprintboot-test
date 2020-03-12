package com.example.sptest;

import com.google.common.collect.Sets;

import java.util.Set;

public class Test1 {

    public static final int PAGE_MAX = 50;
    private static final Set<Long> OFFICE_UIDS;

    static {
        OFFICE_UIDS = Sets.newHashSet(
                8152922548L, //今日话题
                9485866208L, //蛋卷基金
                7489073227L, //雪盈证券
                6123409880L, //交易小助手
                5828665454L, //雪球私募
                5171159182L, //玩赚组合
                2552920054L, //雪球活动
                1287305957L, //雪球访谈
                6163391040L, //需求管理员
                4226803442L  //小秘书
        );

    }

    static int officeCount() {
        return OFFICE_UIDS.size();
    }

}
