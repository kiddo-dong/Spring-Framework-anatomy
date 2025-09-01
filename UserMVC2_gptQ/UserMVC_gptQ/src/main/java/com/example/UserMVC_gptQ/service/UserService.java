package com.example.UserMVC_gptQ.service;

import com.example.UserMVC_gptQ.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> AllUsers();
}