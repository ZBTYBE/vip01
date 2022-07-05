package com.vip.dao;

import com.vip.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("insert into tb_user(username,password,phone,gender,birthday,email,address,description,integral)values (#{username},#{password},#{phone},#{gender},#{birthday},#{email},#{address},#{description},#{integral})")
    void add(User user);

    @Delete("delete from tb_user where uid=#{uid}")
    void deleteByuid(Integer uid);

    @Update("update tb_user set username=#{username},password=#{password},phone=#{phone},gender=#{gender},birthday=#{birthday},email=#{email},address=#{address},description=#{description},integral=#{integral} where uid=#{uid}")
    void update(User user);

    @Select("select * from tb_user")
    List<User> selectAll();

    @Select("select * from tb_user where uid=#{uid}")
    User selectByuid(Integer uid);

    @Select("select * from tb_user where username like #{name}")
    List<User> selectLike(String name);
}
