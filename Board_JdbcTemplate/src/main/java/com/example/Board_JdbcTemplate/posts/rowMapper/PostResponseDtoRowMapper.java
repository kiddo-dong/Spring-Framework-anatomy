package com.example.Board_JdbcTemplate.posts.rowMapper;

import com.example.Board_JdbcTemplate.posts.domain.PostResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostResponseDtoRowMapper implements RowMapper<PostResponseDto> {
    @Override
    public PostResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setPost_id(rs.getLong("post_id"));
        postResponseDto.setNickname(rs.getString("nickname"));
        postResponseDto.setTitle(rs.getString("title"));
        postResponseDto.setCreated_at(rs.getTimestamp("created_at"));
        postResponseDto.setUpdated_at(rs.getTimestamp("updated_at"));
        return postResponseDto;
    }
}