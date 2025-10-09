package com.example.Board_JdbcTemplate.comments.repository;

import com.example.Board_JdbcTemplate.comments.domain.CommentRequestDto;
import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    // Comment 추가
    void addComment(CommentRequestDto commentRequestDto);

    // Comment U,D 를 위한 단일 조회
    Optional<CommentResponseDto> findCommentById(Long comment_id);

    // Post 내에서 Comment 목록 조회
    List<CommentResponseDto> findCommentsByPostId(Long post_id);

    // Comment Update
    void updateCommentById(Long comment_id, CommentRequestDto commentRequestDto);

    // Comment Delete
    void deleteCommentById(Long comment_id);
}