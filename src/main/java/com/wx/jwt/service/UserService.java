package com.wx.jwt.service;

import com.wx.jwt.entity.User;

public interface UserService {
    User findUserById(String id);

    User findByUsername(User user);
    ;
}
