package com.example.JDBC_MySql_test1.repository;

import com.example.JDBC_MySql_test1.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllUser();
    void addUser(User user);
}
