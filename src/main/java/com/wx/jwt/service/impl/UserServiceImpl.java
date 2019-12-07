package com.wx.jwt.service.impl;

import com.wx.jwt.entity.User;
import com.wx.jwt.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(String id) {
        List<User> users = getUser();
        for (User user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByUsername(User user) {
        List<User> users = getUser();
        for (User findUser : users){
            if(findUser.getUsername().equals(user.getUsername())){
                return findUser;
            }
        }
        return null;
    }

    private List<User> getUser(){
        List<User> users = new ArrayList<>();
        User user1 = new User("1","root","root123");
        User user2 = new User("2","root2","root2");
        User user3 = new User("3","test","test");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
