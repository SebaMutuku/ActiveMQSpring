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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        template.convertAndSend(QueueConfigs.queueName1, request);
        System.out.println(request+"received for queue:::::"+QueueConfigs.queueName1);
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
