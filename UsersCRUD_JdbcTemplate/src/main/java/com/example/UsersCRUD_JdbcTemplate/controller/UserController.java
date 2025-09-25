package com.example.UsersCRUD_JdbcTemplate.controller;

import com.example.UsersCRUD_JdbcTemplate.domain.User;
import com.example.UsersCRUD_JdbcTemplate.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userRepository.addUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable int id){
        return userRepository.findUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable int id,
                               @RequestBody User user){
        userRepository.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id){
        userRepository.deleteUserById(id);
    }
}