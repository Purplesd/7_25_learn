package com.iweb.service;

import com.iweb.pojo.User;

public interface UserService {
    User login(User user);
    boolean register(User user);
}
