package com.example.ch9_ex1.service;

import com.example.ch9_ex1.domain.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    void addList(User user);
}
