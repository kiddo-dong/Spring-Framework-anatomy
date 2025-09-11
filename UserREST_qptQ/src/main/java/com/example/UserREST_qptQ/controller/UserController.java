package com.example.UserREST_qptQ.controller;

import com.example.UserREST_qptQ.domain.User;
import com.example.UserREST_qptQ.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> allUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserId(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(
            @PathVariable String id,
            @RequestBody User userRequest
    ){
        // userRequest에서 name, email만 가져옴
        return userService.updateUser(id, userRequest.getName(), userRequest.getEmail());
    }

    @DeleteMapping("/users/{id}")
    public String deleteById(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
