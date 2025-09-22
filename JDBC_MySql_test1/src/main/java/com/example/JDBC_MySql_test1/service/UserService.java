package com.example.JDBC_MySql_test1.service;

import com.example.JDBC_MySql_test1.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> allusers();
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(int id,User user);
    Optional<User> findUser(int id);
}