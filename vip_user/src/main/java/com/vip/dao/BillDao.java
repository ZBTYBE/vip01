package com.vip.dao;

import com.vip.pojo.Bill;
import com.vip.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillDao {
    @Insert("insert into tb_bill(date, point, reason, uid) values(#{date},#{point},#{reason},#{uid})")
    void add(Bill bill);
    @Select("select * from tb_bill where uid=#{uid}")
    List<Bill> select(Integer uid);
}
