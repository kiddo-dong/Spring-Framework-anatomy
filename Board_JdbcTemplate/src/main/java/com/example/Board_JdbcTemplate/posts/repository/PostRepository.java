package com.example.Board_JdbcTemplate.posts.repository;

import com.example.Board_JdbcTemplate.posts.domain.PostListResponseDto;
import com.example.Board_JdbcTemplate.posts.domain.PostRequestDto;
import com.example.Board_JdbcTemplate.posts.domain.PostObjectResponseDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    void addPost(Long user_id, PostRequestDto postRequestDto);
    Optional<PostObjectResponseDto> findPostById(Long post_id);
    List<PostListResponseDto> findAllPosts();
    void UpdatePostById(Long post_id, PostRequestDto postRequestDto);
    void DeletePostById(Long post_id);
}
