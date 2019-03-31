package com.example.sptest.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Author: linjx
 * Date: 2018/10/30
 */
@Configuration
//@EnableJms
public class MqConfig {

    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://xxx:61616");
        // 必须要这个 auth?
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
//        try {
//            Connection connection = connectionFactory.createConnection();
//            connection.start();
//            System.out.println(connection);
//        } catch (Exception ex) {
//        }
        return connectionFactory;
    }

    // consumer
    @Bean
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        //设置连接数
        factory.setConcurrency("3-10");
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        //factory.setMessageConverter(jacksonJmsMessageConverter());
        return factory;
    }
}
