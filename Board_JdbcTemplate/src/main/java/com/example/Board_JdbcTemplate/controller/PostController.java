package com.example.Board_JdbcTemplate.controller;

import com.example.Board_JdbcTemplate.domain.Post;
import com.example.Board_JdbcTemplate.service.PostService;
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

    // POST addPost
    @PostMapping
    public ResponseEntity<Map<String, String>> addPost(@RequestBody Post post){
        postService.addPost(post);
        Map<String, String> map = new HashMap<>();
        map.put("message","add Post Successfully");
        return ResponseEntity
                .ok(map);
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
    public ResponseEntity<Map<String,String>> updatePostById(@PathVariable Long id,
                                                 @RequestBody Post post){
        postService.updatePostById(id, post);

        Map<String, String> map = new HashMap<>();
        map.put("message","update Post Successfully");
        return ResponseEntity
                .ok(map);
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);

        Map<String,String> map = new HashMap<>();
        map.put("message","delete Post Successfully");

        return ResponseEntity
                .ok(map);
    }

}