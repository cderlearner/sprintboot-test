package com.example.sptest.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Author: linjx
 * Date: 2019/4/10
 */
@Component
public class DeadEventHandler extends AbstractEventListener{
    private final static Logger logger = LoggerFactory.getLogger(DeadEventHandler.class);

    @Resource
    private EventBus eventBus1;
    @Resource
    private EventBus eventBus2;

    @Subscribe
    public void handlerDeadEvent(DeadEvent event){
        //handle
        System.out.println("收到事件：" + event);
        System.out.println("事件所在线程：" + Thread.currentThread().getName());
    }

    @Override
    protected Set<EventBus> getEventBusToRegister() {
        return ImmutableSet.of(eventBus1, eventBus2);
    }

    public void post() {
        eventBus1.post(new DeadEvent("1", "2"));
    }
}
