package com.vip.service;

import com.vip.pojo.User;

import java.util.List;

public interface UserService {


    Boolean add(User user);

    Boolean deleteByuid(Integer uid);

    Boolean update(User user);

    List<User> selectAll();

    User selectByuid(Integer uid);

    List<User> selectLike(String name);


}
