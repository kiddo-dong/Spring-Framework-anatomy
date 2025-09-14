package com.example.UserRest_gptQ2.service;

import com.example.UserRest_gptQ2.domain.User;
import com.example.UserRest_gptQ2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(User user) {
        boolean result = userRepository.addUser(user);
        if(result) {
            return "add User Successed";
        }
        return "add User Error";
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findUserById(id);
    }
}