package com.example.UserMVC_ex1.repository;

import com.example.UserMVC_ex1.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    void addUser(User user);
    List<User> UserList();
    Optional<User> findById(String id);
}
