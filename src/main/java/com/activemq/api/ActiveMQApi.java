package com.activemq.api;

import com.activemq.models.Model;
import com.activemq.configs.QueueConfigs;
import com.activemq.utils.GeneralRequest;
import com.activemq.utils.GeneralResponse;
import com.activemq.utils.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@RestController
@RequestMapping("/api")
public class ActiveMQApi {
    @Autowired
    JmsTemplate template;
    GeneralResponse response=new GeneralResponse();

    @PostMapping("/users/activemq/login")
    public ResponseEntity login(@RequestBody UserRequest request) {
        response.setMessage("Your Request has been received.We are Processing it");
        response.setStatus(HttpStatus.PROCESSING);
        System.out.println(request+"received for queue:::::"+QueueConfigs.queueName1);
        this.template.send(QueueConfigs.queueName1, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                final ByteArrayOutputStream bOut = new ByteArrayOutputStream();
                final ObjectOutputStream oOut;
                try {
                    oOut = new ObjectOutputStream(bOut);
                    oOut.writeObject(request); // where object is the object to serialize
                    BytesMessage message = session.createBytesMessage();
                    message.writeBytes(bOut.toByteArray());
                    return message;
                } catch (IOException e) {
                    e.printStackTrace();

                }
                return null;
            }
        });

        return  ResponseEntity.ok(response);


    }
    @PostMapping("/users/activemq/register")
    public ResponseEntity register(@RequestBody GeneralRequest<Model> request) {
        response.setMessage("Kindly sit down and wait");
        response.setStatus(HttpStatus.PROCESSING);
        template.convertAndSend(QueueConfigs.queueName2, request);
        System.out.println(request+"received for queue:::::"+QueueConfigs.queueName2);
        return  ResponseEntity.ok(response);
    }
}
