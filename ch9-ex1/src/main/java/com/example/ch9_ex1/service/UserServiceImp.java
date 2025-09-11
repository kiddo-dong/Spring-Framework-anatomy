package com.example.ch9_ex1.service;

import com.example.ch9_ex1.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements UserService{
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> allUser() {
        return users;
    }

    @Override
    public void addList(User user) {
        users.add(user);
    }
}
