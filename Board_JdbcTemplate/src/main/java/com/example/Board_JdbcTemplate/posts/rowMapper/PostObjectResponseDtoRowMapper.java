package com.example.Board_JdbcTemplate.posts.rowMapper;

import com.example.Board_JdbcTemplate.posts.domain.PostObjectResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostObjectResponseDtoRowMapper implements RowMapper<PostObjectResponseDto> {
    @Override
    public PostObjectResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostObjectResponseDto postObjectResponseDto = new PostObjectResponseDto();
        postObjectResponseDto.setPost_id(rs.getLong("post_id"));
        postObjectResponseDto.setNickname(rs.getString("nickname"));
        postObjectResponseDto.setTitle(rs.getString("title"));
        postObjectResponseDto.setContent(rs.getString("content"));
        postObjectResponseDto.setCreated_at(rs.getTimestamp("created_at"));
        postObjectResponseDto.setUpdated_at(rs.getTimestamp("updated_at"));
        return postObjectResponseDto;
    }
}