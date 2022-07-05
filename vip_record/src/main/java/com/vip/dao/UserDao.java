package com.vip.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select birthday from tb_user where uid=#{uid}")
    String selectBirthday(Integer uid);
    @Select("select username from tb_user where uid=#{uid}")
    String selectName(Integer uid);
}
