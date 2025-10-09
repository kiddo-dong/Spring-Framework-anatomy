package com.example.Board_JdbcTemplate.comments.service;

import com.example.Board_JdbcTemplate.comments.domain.CommentRequestDto;
import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;
import com.example.Board_JdbcTemplate.comments.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImp implements CommentService{

    private final CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(CommentRequestDto commentRequestDto) {
        commentRepository.addComment(commentRequestDto);
    }

    @Override
    public Optional<CommentResponseDto> findCommentById(Long comment_id) {
        return commentRepository.findCommentById(comment_id);
    }

    @Override
    public List<CommentResponseDto> findCommentsByPostId(Long post_id) {
        return commentRepository.findCommentsByPostId(post_id);
    }

    @Override
    public void updateCommentById(Long comment_id, CommentRequestDto commentRequestDto) {
        commentRepository.updateCommentById(comment_id, commentRequestDto);
    }

    @Override
    public void deleteCommentById(Long comment_id) {
        commentRepository.deleteCommentById(comment_id);
    }
}
