package com.example.JDBC_MySql_test1.controller;

import com.example.JDBC_MySql_test1.domain.User;
import com.example.JDBC_MySql_test1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // DB에서 User 전체 꺼내오기
    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity
                .ok(userService.allusers());
    }
    
    //DB에 User 추가
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity
                .ok("Successed add User");
    }
}
