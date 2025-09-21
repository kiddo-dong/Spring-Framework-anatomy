package com.example.JDBC_MySql_test1.service;

import com.example.JDBC_MySql_test1.domain.User;
import com.example.JDBC_MySql_test1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> allusers() {
        return userRepository.findAllUser();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
