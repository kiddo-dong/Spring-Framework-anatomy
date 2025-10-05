package com.example.Board_JdbcTemplate.posts.repository;

import com.example.Board_JdbcTemplate.posts.domain.PostRequestDto;
import com.example.Board_JdbcTemplate.posts.domain.PostResponseDto;
import com.example.Board_JdbcTemplate.posts.rowMapper.PostResponseDtoRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImp implements PostRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Posts C
    @Override
    public void addPost(Long user_id, PostRequestDto postRequestDto){
        String sql = "INSERT INTO posts(user_id, title, content) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,
                user_id,
                postRequestDto.getTitle(),
                postRequestDto.getContent()
        );
    }

    // Posts R Object
    @Override
    public Optional<PostResponseDto> findPostById(Long post_id){
        String sql = "SELECT p.post_id, p.title, p.content, u.nickname, p.created_at, p.updated_at " +
                "FROM posts p " +
                "JOIN users u ON p.user_id = u.user_id " +
                "WHERE p.post_id = ?";
        try {
            PostResponseDto postResponseDto = jdbcTemplate.queryForObject(
                    sql,
                    new PostResponseDtoRowMapper(),
                    post_id
            );

            return Optional.ofNullable(postResponseDto);

        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    // Posts R List(All)
    @Override
    public List<PostResponseDto> findAllPosts(){
        String sql = "SELECT p.post_id, p.title, p.content, u.nickname, p.created_at, p.updated_at " +
                "FROM posts p " +
                "JOIN users u ON p.user_id = u.user_id " +
                "ORDER BY p.created_at DESC " +
                "LIMIT 10 OFFSET 0";

        return jdbcTemplate.query(
                sql,
                new PostResponseDtoRowMapper()
        );
    }

    // Posts U (검증된 사용자만)
    @Override
    public void UpdatePostById(Long post_id, PostRequestDto postRequestDto){
        String sql = "UPDATE posts " +
                "SET title = ?, content = ? " +
                "WHERE post_id = ?";

        jdbcTemplate.update(
                sql,
                postRequestDto.getTitle(),
                postRequestDto.getContent(),
                post_id
        );
    }

    // Posts D (검증된 사용자만)
    @Override
    public void DeletePostById(Long post_id){
        String sql = "DELETE FROM posts WHERE post_id = ?";
        jdbcTemplate.update(sql, post_id);
    }
}