package com.example.UserRest_gptQ2.repository;

import com.example.UserRest_gptQ2.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository{

    private List<User> users = new ArrayList<>();

    @Override
    public boolean addUser(User user) {
        users.add(user);
        return true;
    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public Optional<User> findUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }
}