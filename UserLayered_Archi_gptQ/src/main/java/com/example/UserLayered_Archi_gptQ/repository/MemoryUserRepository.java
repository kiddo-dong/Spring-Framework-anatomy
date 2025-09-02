package com.example.UserLayered_Archi_gptQ.repository;

import com.example.UserLayered_Archi_gptQ.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryUserRepository implements UserRepository{
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user){
        users.add(user);
    }

    @Override
    public List<User> findAll(){
        return users;
    }
}
