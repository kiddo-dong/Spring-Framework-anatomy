package com.example.JDBC_MySql_test1.service;

import com.example.JDBC_MySql_test1.domain.User;

import java.util.List;

public interface UserService {
    List<User> allusers();
    void addUser(User user);
}
