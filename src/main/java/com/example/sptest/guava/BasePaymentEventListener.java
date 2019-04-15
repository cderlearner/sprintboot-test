package com.example.sptest.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Author: linjx
 * Date: 2019/4/10
 */
public abstract class BasePaymentEventListener extends AbstractEventListener{

    @Resource
    private EventBus paymentEventBus;

    @Override
    protected Set<EventBus> getEventBusToRegister() {
        return ImmutableSet.of(paymentEventBus);
    }
}
