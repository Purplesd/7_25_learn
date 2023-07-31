package com.iweb.service.impl;

import com.iweb.DAO.UserDao;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.pojo.User;
import com.iweb.service.UserService;
import com.iweb.util.MD5Util;
import com.iweb.util.UUIDUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userDao.login(user);
    }

    @Override
    public boolean register(User user) {
        if(userDao.verifyUserName(user.getUsername())){
            return false;
        }else {
            user.setId(UUIDUtil.uuid());
            user.setPassword(MD5Util.getMD5(user.getPassword()));
            return userDao.addUser(user);
        }
    }

}
