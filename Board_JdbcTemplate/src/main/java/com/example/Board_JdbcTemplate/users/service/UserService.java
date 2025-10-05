package com.example.Board_JdbcTemplate.users.service;

import com.example.Board_JdbcTemplate.users.domain.User;
import com.example.Board_JdbcTemplate.users.domain.UserRequestDto;
import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;

import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<UserResponseDto> findUserById(Long user_id);
    void updateUserById(Long user_id, UserRequestDto userRequestDto);
    void deleteUserById(Long user_id);
}
