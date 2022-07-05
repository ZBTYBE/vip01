package com.vip.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vip.pojo.Bill;
import com.vip.pojo.Transaction;
import com.vip.service.BillService;
import com.vip.service.rabbitmq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping
    public String addBill(@RequestBody Bill bill){
        billService.add(bill);
        return "";
    }
    @GetMapping("/{uid}")
    public Result selectBill(@PathVariable Integer uid){
        List<Bill> bills = billService.select(uid);
        Integer code=(bills!=null?Code.SELECT_OK:Code.SELECT_ERR);
        String msg=(bills!=null?"":"您查询的结果为空！");
        return new Result(code,bills,msg);
    }

}
