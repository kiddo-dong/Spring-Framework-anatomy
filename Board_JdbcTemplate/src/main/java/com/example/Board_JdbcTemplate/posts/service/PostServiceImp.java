package com.example.Board_JdbcTemplate.posts.service;

import com.example.Board_JdbcTemplate.posts.domain.PostRequestDto;
import com.example.Board_JdbcTemplate.posts.domain.PostResponseDto;
import com.example.Board_JdbcTemplate.posts.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(Long user_id, PostRequestDto postRequestDto) {
        postRepository.addPost(user_id,postRequestDto);
    }

    @Override
    public Optional<PostResponseDto> findPostById(Long post_id) {
        return postRepository.findPostById(post_id);
    }

    @Override
    public List<PostResponseDto> findAllPosts() {
        return postRepository.findAllPosts();
    }

    @Override
    public void UpdatePostById(Long post_id, PostRequestDto postRequestDto) {
        postRepository.UpdatePostById(post_id, postRequestDto);
    }

    @Override
    public void DeletePostById(Long post_id) {
        postRepository.DeletePostById(post_id);
    }
}