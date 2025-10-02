package com.example.Board_JdbcTemplate.controller;

import com.example.Board_JdbcTemplate.domain.Post;
import com.example.Board_JdbcTemplate.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // POST addPost
    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Post post){
        postService.addPost(post);
        return ResponseEntity
                .ok("add Post Successfully");
    }

    // GET Post List
    @GetMapping
    public ResponseEntity<List<Post>> findAllPost(){
        return ResponseEntity
                .ok(postService.findAllPost());
    }

    // GET Post Object
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(postService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePostById(@PathVariable Long id,
                                                 @RequestBody Post post){
        postService.updatePostById(id, post);
        return ResponseEntity
                .ok("update Post Successfully");
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
        return ResponseEntity
                .ok("delete Post Successfully");
    }

}