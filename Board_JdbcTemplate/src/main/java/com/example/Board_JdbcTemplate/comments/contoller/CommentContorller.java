package com.example.Board_JdbcTemplate.comments.contoller;

import com.example.Board_JdbcTemplate.comments.domain.CommentRequestDto;
import com.example.Board_JdbcTemplate.comments.domain.CommentResponseDto;
import com.example.Board_JdbcTemplate.comments.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posts/{post_id}/comments") // comments는 posts에 귀속
public class CommentContorller {

    private final CommentService commentService;

    public CommentContorller(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createComment(
            @PathVariable Long post_id,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        // DTO에서 user_id를 가져옴 (JWT 적용 전)
        commentService.addComment(commentRequestDto.getUser_id(), post_id, commentRequestDto.getContent());

        Map<String, String> result = new HashMap<>();
        result.put("message", "Comment created successfully");
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getCommentsByPostId(
            @PathVariable Long post_id
    ) {
        List<CommentResponseDto> comments = commentService.findCommentsByPostId(post_id);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{comment_id}")
    public ResponseEntity<Map<String, String>> updateComment(
            @PathVariable Long post_id,
            @PathVariable Long comment_id,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        // DTO에서 user_id를 가져와 검증
        commentService.updateCommentById(commentRequestDto.getUser_id(), post_id, comment_id, commentRequestDto.getContent());

        Map<String, String> result = new HashMap<>();
        result.put("message", "Comment updated successfully");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity<Map<String, String>> deleteComment(
            @PathVariable Long post_id,
            @PathVariable Long comment_id,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        commentService.deleteCommentById(commentRequestDto.getUser_id(), post_id, comment_id);

        Map<String, String> result = new HashMap<>();
        result.put("message", "Comment deleted successfully");
        return ResponseEntity.ok(result);
    }
}