package com.example.Board_JdbcTemplate.users.repository;

import com.example.Board_JdbcTemplate.users.domain.User;
import com.example.Board_JdbcTemplate.users.domain.UserRequestDto;
import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;

import java.util.Optional;

public interface UserRepository {
    void addUser(User user);
    Optional<UserResponseDto> findUserById(Long User_id);
    void updateUserById(Long user_id, UserRequestDto userRequestDto);
    void deleteUserById(Long user_id);
}