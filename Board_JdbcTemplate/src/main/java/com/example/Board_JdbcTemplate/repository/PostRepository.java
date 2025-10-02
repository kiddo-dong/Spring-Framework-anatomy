package com.example.Board_JdbcTemplate.repository;

import com.example.Board_JdbcTemplate.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    // POST
    void addPost(Post post);

    // GET
    List<Post> findAllPost();
    Optional<Post> findById(Long id);

    // Update
    void updatePostById(Long id,Post post);

    // Delete
    void deletePostById(Long id);


}
