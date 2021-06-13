package com.activemq.processors;


import com.activemq.configs.QueueConfigs;
import com.activemq.models.Model;
import com.activemq.utils.GeneralRequest;
import com.activemq.utils.UserRequest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

    @JmsListener(destination = QueueConfigs.queueName1)
    public void processorQueue1Info(UserRequest request){
        System.out.println("Processing Infomation========="+request+" For queue:::::"+QueueConfigs.queueName1);
    }
    @JmsListener(destination = QueueConfigs.queueName2)
    public void processorQueue2Info(GeneralRequest<Model> request){
        System.out.println("Processing Infomation========="+request+" For queue:::::"+QueueConfigs.queueName2);
    }

}
