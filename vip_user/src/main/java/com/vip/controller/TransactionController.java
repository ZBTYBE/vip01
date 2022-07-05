package com.vip.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vip.pojo.Transaction;
import com.vip.service.rabbitmq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    MessageService messageService;

    @PostMapping
    public Result transaction(@RequestBody Transaction transaction) throws JsonProcessingException {
        System.out.println(transaction);
        messageService.sendMessage(transaction);
        Integer code=Code.ADD_OK;
        String msg="添加成功";
        return new Result(code,msg);

    }
}
