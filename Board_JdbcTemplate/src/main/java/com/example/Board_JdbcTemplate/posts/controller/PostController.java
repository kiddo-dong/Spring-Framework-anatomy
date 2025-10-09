package com.example.Board_JdbcTemplate.posts.controller;

import com.example.Board_JdbcTemplate.posts.domain.PostListResponseDto;
import com.example.Board_JdbcTemplate.posts.domain.PostRequestDto;
import com.example.Board_JdbcTemplate.posts.domain.PostObjectResponseDto;
import com.example.Board_JdbcTemplate.posts.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/users/{user_id}")
    public ResponseEntity<Map<String, String>> addPost(
            @PathVariable Long user_id,
            @RequestBody PostRequestDto postRequestDto
            ){
        postService.addPost(user_id, postRequestDto);

        Map<String, String> response = new HashMap<>();
        response.put("message","add successfully");

        return ResponseEntity
                .ok(response);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<Optional<PostObjectResponseDto>> findPostById(@PathVariable Long post_id){
        return ResponseEntity
                .ok(postService.findPostById(post_id));
    }

    @GetMapping
    public ResponseEntity<List<PostListResponseDto>> findPostAll(){
        return  ResponseEntity
                .ok(postService.findAllPosts());
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<Map<String, String>> updatePostById(
            @PathVariable Long post_id,
            @RequestBody PostRequestDto postRequestDto
    ) {
        postService.UpdatePostById(post_id, postRequestDto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<Map<String, String>> deletePostById(@PathVariable Long post_id){
        postService.DeletePostById(post_id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "deleted successfully");

        return ResponseEntity
                .ok(response);

    }
}
