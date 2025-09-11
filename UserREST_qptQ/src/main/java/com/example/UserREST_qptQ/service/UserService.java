package com.example.UserREST_qptQ.service;

import com.example.UserREST_qptQ.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(User user);
    Optional<User> findById(String id);
    User updateUser(String id, String newName, String newEmail);
    String deleteUser(String id);
    List<User> getAllUsers();
}
