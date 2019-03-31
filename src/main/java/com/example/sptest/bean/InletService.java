package com.example.sptest.bean;

import com.example.sptest.bean.dto.*;

/**
 * 合作方->知乎
 * Author: linjx
 * Date: 2019/3/28
 */
public interface InletService {
    /**
     * 向知乎发起会员开通权限查询
     */
    CanOpenResponse canOpen(CanOpenRequest request);
    /**
     * 向知乎发起会员注册，注册成功发放权益
     */
    OrderCreateResponse registerMember(OrderCreateRequest request);
    /**
     * 向知乎发起会员有效时长查询
     */
    QueryMemberValidityResponse queryMemberValidity(QueryMemberValidityRequest request);
    /**
     * 向知乎发起订单查询
     */
    QueryOrderResponse queryOrder(QueryOrderRequest request);
    /**
     * 向知乎发起主权益退款
     */
    RefundMemberResponse refundMajorMember(RefundMajorMemberRequest request);
    /**
     * 向知乎发起副权益退款
     */
    RefundMemberResponse refundMinorMember(RefundMinorMemberRequest request);
}
