package com.example.UserMVC_ex1.service;

import com.example.UserMVC_ex1.domain.User;
import com.example.UserMVC_ex1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<User> findAllUser() {
        return userRepository.UserList();
    }

    @Override
    public User findById(String id) {
        if(userRepository.findById(id).get().Optional.empty()){

        }
    }
}
