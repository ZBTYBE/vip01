package com.vip.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vip.pojo.Bill;
import com.vip.pojo.Transaction;
import com.vip.service.ConversionService;
import com.vip.service.SendService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class MessageListener {
    @Autowired
    ConversionService conversionService;

    @Autowired
    SendService sendService;

    @RabbitListener(queues = "directQueue")
    public void receive(String message) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Transaction transaction = mapper.readValue(message.getBytes("utf-8"), Transaction.class);
        Bill bill = conversionService.conversion(transaction);
        sendService.send(bill);


    }

}
