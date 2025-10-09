package com.example.Board_JdbcTemplate.comments.rowMapper;

import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentResponseDtoRowMapper implements RowMapper<CommentResponseDto> {
    @Override
    public CommentResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CommentResponseDto commentResponseDto = new CommentResponseDto();

        commentResponseDto.setComment_id(rs.getLong("comment_id"));
        commentResponseDto.setPost_id(rs.getLong("post_id"));
        commentResponseDto.setUser_id(rs.getLong("user_id"));
        commentResponseDto.setNickname(rs.getString("nickname"));
        commentResponseDto.setContent(rs.getString("content"));
        commentResponseDto.setCreated_at(rs.getTimestamp("created_at"));
        commentResponseDto.setUpdated_at(rs.getTimestamp("updated_at"));
        return  commentResponseDto;
    }
}
