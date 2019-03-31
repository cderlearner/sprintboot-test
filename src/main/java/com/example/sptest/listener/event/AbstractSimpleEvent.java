package com.example.sptest.listener.event;

import org.springframework.context.ApplicationEvent;

public abstract class AbstractSimpleEvent<T> extends ApplicationEvent {
    private T payload;

    protected AbstractSimpleEvent(Object source, T payload) {
        super(source);
        this.payload = payload;
    }

    public final T getPayload() {
        return payload;
    }
}
