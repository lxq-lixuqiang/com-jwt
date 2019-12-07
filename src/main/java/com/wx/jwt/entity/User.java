package com.wx.jwt.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    public User(){}
    public User(String id,String username,String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }

    private static final long serialVersionUID = -8508165125922082306L;
    private String id;
    private String username;
    private String password;
}
