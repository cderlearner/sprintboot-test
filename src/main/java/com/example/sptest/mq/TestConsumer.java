package com.example.sptest.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2018/10/30
 */
@Component
public class TestConsumer extends MessageListenerAdapter {

    @JmsListener(destination = "SampleTopic1", containerFactory = "jmsQueueListenerContainerFactory")
    public void receiveMessage(TestMessage testMessage) {
        System.out.println("Received <" + testMessage + ">");
    }

}
