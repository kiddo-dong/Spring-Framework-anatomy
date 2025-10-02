package com.example.Board_JdbcTemplate.service;

import com.example.Board_JdbcTemplate.domain.Post;
import com.example.Board_JdbcTemplate.repository.PostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImp implements PostService{

    private final PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAllPost();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void updatePostById(Long id, Post post) {
        postRepository.updatePostById(id, post);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deletePostById(id);
    }
}
