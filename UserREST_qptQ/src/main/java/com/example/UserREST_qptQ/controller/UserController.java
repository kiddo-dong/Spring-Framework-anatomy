package com.example.UserREST_qptQ.controller;

import com.example.UserREST_qptQ.domain.User;
import com.example.UserREST_qptQ.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Rest API 기초
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

    // id 를 Path request로 지정해서 필수로 값을 받아옴
    @GetMapping("/users/{id}")
    public Optional<User> getUserId(@PathVariable String id){
        return userService.findById(id);
    }
    //Optional<User> 으로 User 객체를 반환 REST

    // Front-End에서 Submit 등 데이터 저장시 Post 호출
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