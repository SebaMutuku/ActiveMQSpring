package com.activemq.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class MessageConfigs {

    @Bean
    public DefaultJmsListenerContainerFactory factory(ConnectionFactory factory){
      DefaultJmsListenerContainerFactory containerFactory=  new DefaultJmsListenerContainerFactory();
      containerFactory.setConnectionFactory(factory);
      containerFactory.setConcurrency(QueueConfigs.concurrency1);
      return containerFactory;

    }
    @Bean
    public MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }
}
