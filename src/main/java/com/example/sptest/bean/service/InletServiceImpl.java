package com.example.sptest.bean.service;

import com.example.sptest.bean.InletService;
import com.example.sptest.bean.dto.*;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

/**
 * Author: linjx
 * Date: 2019/3/28
 */
@Service
public class InletServiceImpl implements InletService {
    private final Map<String, Partner> appToPartner = Maps.newHashMap();

    @Autowired
    private NoopInletService partnerNoop;
    @Autowired
    private PartnerYJY partnerYjyg;
    @Autowired
    private PartnerTest partnerTest;

    @PostConstruct
    protected void init() {
        appToPartner.put(partnerYjyg.getOnlineAppId(), partnerYjyg);
        appToPartner.put(partnerTest.getOnlineAppId(), partnerTest);
    }

    @Override
    public CanOpenResponse canOpen(CanOpenRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).canOpen(request);
    }

    @Override
    public OrderCreateResponse registerMember(OrderCreateRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).registerMember(request);
    }

    @Override
    public QueryMemberValidityResponse queryMemberValidity(QueryMemberValidityRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).queryMemberValidity(request);
    }

    @Override
    public QueryOrderResponse queryOrder(QueryOrderRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).queryOrder(request);
    }

    @Override
    public RefundMemberResponse refundMajorMember(RefundMajorMemberRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).refundMajorMember(request);
    }

    @Override
    public RefundMemberResponse refundMinorMember(RefundMinorMemberRequest request) {
        return Optional.ofNullable(appToPartner.get(request.getAppId())).orElse(partnerNoop).refundMinorMember(request);
    }
}
