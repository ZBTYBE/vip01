package com.vip.service.impl;

import com.vip.pojo.Bill;
import com.vip.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    RestTemplate restTemplate;
    @Override
    public void send(Bill bill) {

        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url="http://localhost:8080/bills";

        HttpEntity<Bill> entityParam=new HttpEntity<Bill>(bill,headers);

        restTemplate.postForObject(url, entityParam, Bill.class);


    }
}
