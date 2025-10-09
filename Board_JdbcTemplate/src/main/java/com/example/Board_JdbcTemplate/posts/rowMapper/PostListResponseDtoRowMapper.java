package com.example.Board_JdbcTemplate.posts.rowMapper;

import com.example.Board_JdbcTemplate.posts.domain.PostListResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostListResponseDtoRowMapper implements RowMapper<PostListResponseDto> {
    @Override
    public PostListResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostListResponseDto postListResponseDto = new PostListResponseDto();

        postListResponseDto.setPost_id(rs.getLong("post_id"));
        postListResponseDto.setNickname(rs.getString("nickname"));
        postListResponseDto.setTitle(rs.getString("title"));
        postListResponseDto.setCreated_at(rs.getTimestamp("created_at"));
        postListResponseDto.setUpdated_at(rs.getTimestamp("updated_at"));
        return postListResponseDto;
    }
}
