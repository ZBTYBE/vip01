package com.vip.service.impl;

import com.vip.dao.UserDao;
import com.vip.pojo.Bill;
import com.vip.pojo.Transaction;
import com.vip.service.ConversionService;
import com.vip.service.rabbitmq.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    UserDao userDao;

    public Bill conversion(Transaction transaction) {
        Bill bill = new Bill();
        Integer uid = transaction.getUid();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        bill.setDate(date);
        String birthday = userDao.selectBirthday(uid);
        Integer point;
        if(birthday.equals(date)){
            point=(int) (transaction.getPayment() *200);
        }else {
            point=(int) (transaction.getPayment() *100);
        }
        bill.setPoint(point);
        StringBuilder s=new StringBuilder("用户");
        String username = userDao.selectName(uid);
        s.append(username);
        s.append("通过");
        s.append(transaction.getWay());
        s.append("购买");
        s.append(transaction.getGoods());
        s.append("消费");
        s.append(transaction.getPayment());
        s.append("元");
        String reason= String.valueOf(s);
        bill.setReason(reason);
        bill.setUid(uid);
        return bill;
    }
}
