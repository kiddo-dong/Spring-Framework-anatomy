package com.example.UserCRUD_DataSource.service;

import com.example.UserCRUD_DataSource.domain.User;
import com.example.UserCRUD_DataSource.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public Optional<User> findUser(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userRepository.updateUserById(id, user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUserById(id);
    }
}
