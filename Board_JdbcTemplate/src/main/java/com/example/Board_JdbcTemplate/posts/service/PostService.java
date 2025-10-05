package com.example.Board_JdbcTemplate.posts.service;

import com.example.Board_JdbcTemplate.posts.domain.PostRequestDto;
import com.example.Board_JdbcTemplate.posts.domain.PostResponseDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void addPost(Long user_id, PostRequestDto postRequestDto);
    Optional<PostResponseDto> findPostById(Long post_id);
    List<PostResponseDto> findAllPosts();
    void UpdatePostById(Long post_id, PostRequestDto postRequestDto);
    void DeletePostById(Long post_id);
}
