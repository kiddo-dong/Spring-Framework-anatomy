package com.example.UserLayered_Archi_gptQ.repository;

import com.example.UserLayered_Archi_gptQ.domain.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
}
