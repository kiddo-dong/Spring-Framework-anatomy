package com.example.JDBC_MySql_test1.repository;

import com.example.JDBC_MySql_test1.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAllUser();
    void addUser(User user);
    void deleteUserById(int id);
    void updateByUser(int id, User user);
    Optional<User> findUserById(int id);
}