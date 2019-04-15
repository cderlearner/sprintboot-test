package com.example.sptest.guava;

import com.google.common.eventbus.EventBus;
import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Author: linjx
 * Date: 2019/4/10
 */
public abstract class AbstractEventListener {

    @PostConstruct
    public void init() {
        for (EventBus eventBus : getEventBusToRegister()) {
            eventBus.register(this);
        }
    }

    protected abstract Set<EventBus> getEventBusToRegister();
}
