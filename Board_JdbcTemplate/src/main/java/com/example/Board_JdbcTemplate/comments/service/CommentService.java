package com.example.Board_JdbcTemplate.comments.service;

import com.example.Board_JdbcTemplate.comments.domain.CommentRequestDto;
import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    void addComment(CommentRequestDto commentRequestDto);

    Optional<CommentResponseDto> findCommentById(Long comment_id);

    List<CommentResponseDto> findCommentsByPostId(Long post_id);

    void updateCommentById(Long comment_id, CommentRequestDto commentRequestDto);

    void deleteCommentById(Long comment_id);
}