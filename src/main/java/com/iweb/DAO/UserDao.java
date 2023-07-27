package com.iweb.DAO;

import com.iweb.pojo.User;

public interface UserDao {
    User login(User user);
    boolean verifyUserName(String username);
    boolean addUser(User user);
}
