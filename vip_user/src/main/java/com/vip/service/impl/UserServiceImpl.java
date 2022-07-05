package com.vip.service.impl;

import com.vip.dao.UserDao;
import com.vip.pojo.User;
import com.vip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Boolean add(User user) {
        userDao.add(user);
        return true;
    }

    @Override
    public Boolean deleteByuid(Integer uid) {
        userDao.deleteByuid(uid);
        return true;
    }

    @Override
    public Boolean update(User user) {
        userDao.update(user);
        return true;
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectByuid(Integer uid) {
        return userDao.selectByuid(uid);
    }

    @Override
    public List<User> selectLike(String name) {
        name="%"+name+"%";
        return userDao.selectLike(name);
    }
}
