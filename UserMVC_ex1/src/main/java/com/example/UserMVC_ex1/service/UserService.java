package com.example.UserMVC_ex1.service;

import com.example.UserMVC_ex1.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> findAllUser();
    User findById(String id);
}
