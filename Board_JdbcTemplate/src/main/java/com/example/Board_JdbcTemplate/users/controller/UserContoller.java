package com.example.Board_JdbcTemplate.users.controller;

import com.example.Board_JdbcTemplate.users.domain.User;
import com.example.Board_JdbcTemplate.users.domain.UserRequestDto;
import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;
import com.example.Board_JdbcTemplate.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserContoller {

    private final UserService userService;

    // DI
    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addUser(@RequestBody User user){

        userService.addUser(user);

        Map<String, String> map = new HashMap<>();
        map.put("message", "successfully");
        return ResponseEntity
                .ok(map);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<Optional<UserResponseDto>> findUser(@PathVariable Long user_id){
        return ResponseEntity
                .ok(userService.findUserById(user_id));
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<Map<String, String>> updateUserById(@PathVariable Long user_id,
                                                              @RequestBody UserRequestDto userRequestDto){

        userService.updateUserById(user_id, userRequestDto);

        Map<String,String> map = new HashMap<>();
        map.put("message", "successfully");

        return ResponseEntity
                .ok(map);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable Long user_id) {
        userService.deleteUserById(user_id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "successfully");

        return ResponseEntity
                .ok(map);
    }
}
