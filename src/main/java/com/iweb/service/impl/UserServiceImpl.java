package com.iweb.service.impl;

import com.iweb.DAO.UserDao;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.pojo.User;
import com.iweb.service.UserService;
import com.iweb.util.MD5Util;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userDao.login(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean verifyUserName(String username) {
        return userDao.verifyUserName(username);
    }
}
