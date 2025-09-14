package com.example.UserRest_gptQ2.controller;

import com.example.UserRest_gptQ2.domain.User;
import com.example.UserRest_gptQ2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> AllUsers(){
        return userService.findAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findUserById(@PathVariable String id){
        return userService.findUserById(id);
    }
}