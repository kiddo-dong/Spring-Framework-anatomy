package com.example.Board_JdbcTemplate.users.rowMapper;

import com.example.Board_JdbcTemplate.users.domain.UserResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResponseDtoRowMapper implements RowMapper<UserResponseDto> {
    @Override
    public UserResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUser_id(rs.getLong("user_id"));
        userResponseDto.setNickname(rs.getString("nickname"));
        userResponseDto.setCreated_at(rs.getTimestamp("created_at"));
        userResponseDto.setUpdated_at(rs.getTimestamp("updated_at"));

        return userResponseDto;
    }
}
