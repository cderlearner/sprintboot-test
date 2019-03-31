package com.example.sptest.bean.service;

import com.example.sptest.bean.dto.*;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Component
public class NoopInletService extends Partner {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public CanOpenResponse canOpen(CanOpenRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        System.err.println(this.toString());
        throw new RuntimeException("Noop");
    }

    @Override
    public OrderCreateResponse registerMember(OrderCreateRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        throw new RuntimeException("Noop");
    }

    @Override
    public QueryMemberValidityResponse queryMemberValidity(QueryMemberValidityRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        throw new RuntimeException("Noop");
    }

    @Override
    public QueryOrderResponse queryOrder(QueryOrderRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        throw new RuntimeException("Noop");
    }

    @Override
    public RefundMemberResponse refundMajorMember(RefundMajorMemberRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        throw new RuntimeException("Noop");
    }

    @Override
    public RefundMemberResponse refundMinorMember(RefundMinorMemberRequest request) {
        logger.warn("Invalid appId:{}", request.getAppId());
        throw new RuntimeException("Noop");
    }

    @Override
    String getOnlineAppId() {
        return Strings.EMPTY;
    }

    @Override
    String getSandboxAppId() {
        return Strings.EMPTY;
    }
}
