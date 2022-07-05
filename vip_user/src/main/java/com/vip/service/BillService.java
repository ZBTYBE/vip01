package com.vip.service;

import com.vip.pojo.Bill;

import java.util.List;

public interface BillService {
    void add(Bill bill);
    List<Bill> select(Integer uid);
}
