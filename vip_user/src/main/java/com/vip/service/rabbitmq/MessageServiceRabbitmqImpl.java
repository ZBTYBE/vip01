package com.vip.service.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vip.pojo.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MessageServiceRabbitmqImpl implements MessageService{
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(Transaction transaction) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        String message=mapper.writeValueAsString(transaction);

        amqpTemplate.convertAndSend("directExchange","direct",message.getBytes());
    }

    @Override
    public String doMessage() {
        return null;
    }
}
