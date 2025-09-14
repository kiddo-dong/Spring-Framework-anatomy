package com.example.UserRest_gptQ2.repository;

import com.example.UserRest_gptQ2.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean addUser(User user);
    List<User> findAllUser();
    Optional<User> findUserById(String id);
}
