package com.example.UserCRUD_DataSource.repository;

import com.example.UserCRUD_DataSource.domain.User;

import java.util.Optional;

public interface UserRepository {
    //CRUD
    void addUser(User user);
    Optional<User> findUserById(int id);
    void updateUserById(int id, User user);
    void deleteUserById(int id);
}