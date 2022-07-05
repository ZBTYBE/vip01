package com.vip.service.impl;

import com.vip.dao.BillDao;
import com.vip.pojo.Bill;
import com.vip.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;


    @Override
    public void add(Bill bill) {
        billDao.add(bill);
    }

    @Override
    public List<Bill> select(Integer uid) {
        return billDao.select(uid);
    }
}
