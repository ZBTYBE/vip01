package com.vip;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vip.pojo.Transaction;
import com.vip.pojo.User;
import com.vip.service.UserService;
import com.vip.service.rabbitmq.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootTest
class VipUserApplicationTests {
    @Autowired
    MessageService messageService;

    @Test
    void contextLoads() throws JsonProcessingException {
        Transaction t = new Transaction(1,"111",11.1,"1111");
        messageService.sendMessage(t);

    }
}
