package com.example.UserMVC_gptQ.service;

import com.example.UserMVC_gptQ.domain.User;
import com.example.UserMVC_gptQ.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public List<User> AllUsers() {
        return userRepository.getUserList();
    }
}