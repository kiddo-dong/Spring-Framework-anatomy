package com.example.UserMVC_gptQ.repository;

import com.example.UserMVC_gptQ.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public void saveUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
