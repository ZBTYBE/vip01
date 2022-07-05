package com.vip.service;

import com.vip.pojo.Bill;
import com.vip.pojo.Transaction;

public interface ConversionService {
    Bill conversion(Transaction transaction);
}
