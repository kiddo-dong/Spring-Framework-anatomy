package com.example.Board_JdbcTemplate.repository;

import com.example.Board_JdbcTemplate.domain.Post;
import com.example.Board_JdbcTemplate.rowMapper.PostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImp implements PostRepository{

    private final JdbcTemplate jdbcTemplate;

    public PostRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // post 게시글 생성
    @Override
    public void addPost(Post post) {
        String sql = "INSERT INTO posts(title, content) VALUES(?, ?)";

        jdbcTemplate.update(sql, post.getTitle(), post.getContent());
    }

    @Override
    public List<Post> findAllPost() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }

    @Override
    public Optional<Post> findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(sql, new PostRowMapper(), id);
        return Optional.ofNullable(post);
    }

    @Override
    public void updatePostById(Long id, Post post) {
        String sql = "UPDATE posts SET title=?, content=? WHERE id=?";

        jdbcTemplate.update(sql,post.getTitle(), post.getContent(), id);
    }

    @Override
    public void deletePostById(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}
