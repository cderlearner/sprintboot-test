package com.example.sptest.bean.service;

import com.example.sptest.bean.InletService;
import com.example.sptest.bean.dto.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;

/**
 * Author: linjx
 * Date: 2019/3/29
 */
public abstract class Partner implements InletService {
    @Autowired
    private Validator validator;

    public CanOpenResponse canOpen(CanOpenRequest request) {
        System.out.println("Yjy canOpen");
        System.err.println(this.toString());
        return new CanOpenResponse();
    }

    @Override
    public OrderCreateResponse registerMember(OrderCreateRequest request) {
        return null;
    }

    @Override
    public QueryMemberValidityResponse queryMemberValidity(QueryMemberValidityRequest request) {
        return null;
    }

    @Override
    public QueryOrderResponse queryOrder(QueryOrderRequest request) {
        return null;
    }

    @Override
    public RefundMemberResponse refundMajorMember(RefundMajorMemberRequest request) {
        return null;
    }

    @Override
    public RefundMemberResponse refundMinorMember(RefundMinorMemberRequest request) {
        return null;
    }

    abstract String getOnlineAppId();

    abstract String getSandboxAppId();



}
