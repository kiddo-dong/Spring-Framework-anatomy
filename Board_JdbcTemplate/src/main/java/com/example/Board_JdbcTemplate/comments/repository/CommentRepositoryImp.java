package com.example.Board_JdbcTemplate.comments.repository;

import com.example.Board_JdbcTemplate.comments.domain.CommentRequestDto;
import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;
import com.example.Board_JdbcTemplate.comments.rowMapper.CommentResponseDtoRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryImp implements CommentRepository{

    private final JdbcTemplate jdbcTemplate;

    public CommentRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addComment(CommentRequestDto commentRequestDto) {
        String sql = "INSERT INTO comments(post_id, user_id, content) VALUES(?, ?, ?)";

        jdbcTemplate.update(
                sql,
                commentRequestDto.getPost_id(),
                commentRequestDto.getUser_id(),
                commentRequestDto.getContent()
        );
    }

    @Override
    public Optional<CommentResponseDto> findCommentById(Long comment_id) {
        String sql = "SELECT c.comment_id, c.post_id, c.user_id, u.nickname, c.content, c.created_at, c.updated_at " +
                "FROM comments c " +
                "JOIN users u ON c.user_id = u.user_id " +
                "WHERE c.comment_id = ?";

        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    sql,
                    new CommentResponseDtoRowMapper(),
                    comment_id
            ));

        } catch(EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<CommentResponseDto> findCommentsByPostId(Long post_id) {
        String sql = "SELECT c.comment_id, c.post_id, c.user_id, u.nickname, c.content, c.created_at, c.updated_at " +
                "FROM comments c " +
                "JOIN users u ON c.user_id = u.user_id " +
                "WHERE c.post_id = ? " +
                "ORDER BY c.created_at DESC";

       return jdbcTemplate.query(
               sql,
               new CommentResponseDtoRowMapper(),
               post_id
       );
    }

    @Override
    public void updateCommentById(Long comment_id, CommentRequestDto commentRequestDto) {
        String sql = "UPDATE comments " +
                "SET content = ? " +
                "WHERE comment_id = ?";

        jdbcTemplate.update(sql, commentRequestDto.getContent(), comment_id);
    }

    @Override
    public void deleteCommentById(Long comment_id) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(sql, comment_id);
    }
}
