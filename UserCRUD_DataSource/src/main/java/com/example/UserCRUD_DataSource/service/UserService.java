package com.example.UserCRUD_DataSource.service;

import com.example.UserCRUD_DataSource.domain.User;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> findUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}