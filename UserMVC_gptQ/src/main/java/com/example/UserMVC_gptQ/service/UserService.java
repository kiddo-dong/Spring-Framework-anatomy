package com.example.UserMVC_gptQ.service;

import com.example.UserMVC_gptQ.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> users= new ArrayList<>();

    public void addUser(User u){
        users.add(u);
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()       // Optional<User>
                .orElse(null);   // 없으면 null 반환
    }


    public boolean deleteUserById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
