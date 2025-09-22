package com.example.JDBC_MySql_test1.controller;

import com.example.JDBC_MySql_test1.domain.User;
import com.example.JDBC_MySql_test1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
                .ok("User Add Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);

        return ResponseEntity
                .ok("user Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putUpdateUser(@PathVariable int id,
                                                @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity
                .ok("user update(put) Successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUser(@PathVariable int id){
        return ResponseEntity
                .ok(userService.findUser(id));
    }
}
