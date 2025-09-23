package com.example.UserCRUD_DataSource.controller;

import com.example.UserCRUD_DataSource.domain.User;
import com.example.UserCRUD_DataSource.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity
                .ok("사용자 정보 정상적으로 저장됨.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUser(@PathVariable int id){
        return ResponseEntity
                .ok(userService.findUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id,
                                             @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity
                .ok("사용자 정보 업데이트 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok("사용자 정보 삭제 완료");
    }
}
