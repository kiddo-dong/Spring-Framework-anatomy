package com.example.Board_JdbcTemplate.users.repository;

import com.example.Board_JdbcTemplate.users.domain.User;
import com.example.Board_JdbcTemplate.users.domain.UserRequestDto;
import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;
import com.example.Board_JdbcTemplate.users.rowMapper.UserResponseDtoRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    // JdbcTemplate Bean DI
    public UserRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users(nickname, password) VALUES(?, ?)";
        jdbcTemplate.update(sql, user.getNickname(), user.getPassword());
    }

    @Override
    public Optional<UserResponseDto> findUserById(Long user_id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        return Optional
                .ofNullable(
                        jdbcTemplate.queryForObject(sql, new UserResponseDtoRowMapper(), user_id)
                );
    }

    @Override
    public void updateUserById(Long user_id, UserRequestDto userRequestDto) {
        String sql = "UPDATE users SET nickname = ?, password = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, userRequestDto.getNickname(), userRequestDto.getPassword(), user_id);
    }

    @Override
    public void deleteUserById(Long user_id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        jdbcTemplate.update(sql, user_id);
    }
}
