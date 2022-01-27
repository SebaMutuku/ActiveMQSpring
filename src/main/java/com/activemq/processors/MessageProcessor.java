package com.activemq.processors;


import com.activemq.configs.QueueConfigs;
import com.activemq.models.Model;
import com.activemq.utils.GeneralRequest;
import com.activemq.utils.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
public class MessageProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProcessor.class);


    @JmsListener(destination = QueueConfigs.queueName1)
    public void processorQueue1Info(Message request) throws JMSException, IOException, ClassNotFoundException {
        LOGGER.info("*******Incoming request to save customer from activeMQ " + request);
        final BytesMessage requestBytes = (BytesMessage) request;
        final byte[] array = new byte[Long.valueOf(requestBytes.getBodyLength()).intValue()];
        requestBytes.readBytes(array);
        final ByteArrayInputStream bIn = new ByteArrayInputStream(array);
        final ObjectInputStream oIn = new ObjectInputStream(bIn);
        UserRequest userRequest = (UserRequest) oIn.readObject();
    }
    @JmsListener(destination = QueueConfigs.queueName2)
    public void processorQueue2Info(GeneralRequest<Model> request){
        System.out.println("Processing Infomation========="+request+" For queue:::::"+QueueConfigs.queueName2);
    }

}
