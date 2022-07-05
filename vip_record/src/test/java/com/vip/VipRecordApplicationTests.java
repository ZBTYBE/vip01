package com.vip;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vip.pojo.Transaction;
import com.vip.service.ConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VipRecordApplicationTests {

    @Autowired
    ConversionService conversionService;

    @Test
    void contextLoads(){

    }


}
