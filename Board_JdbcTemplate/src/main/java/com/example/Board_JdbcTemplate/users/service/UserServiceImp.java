package com.example.Board_JdbcTemplate.users.service;

import com.example.Board_JdbcTemplate.users.domain.User;
import com.example.Board_JdbcTemplate.users.domain.UserRequestDto;
import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;
import com.example.Board_JdbcTemplate.users.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public Optional<UserResponseDto> findUserById(Long user_id) {
        return userRepository.findUserById(user_id);
    }

    @Override
    public void updateUserById(Long user_id, UserRequestDto userRequestDto) {
        userRepository.updateUserById(user_id, userRequestDto);
    }

    @Override
    public void deleteUserById(Long user_id) {
        userRepository.deleteUserById(user_id);
    }
}