package com.vip.service.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vip.pojo.Transaction;

public interface MessageService {
    void sendMessage(Transaction transaction) throws JsonProcessingException;
    String doMessage();
}
