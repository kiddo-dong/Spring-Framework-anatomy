package com.example.Board_JdbcTemplate.comments.domain;

// Request DTO
// POST METHOD
public class CommentRequestDto {

    private Long post_id;   // 댓글이 달릴 게시글 ID
    private Long user_id;   // 댓글 작성자 ID (JWT 적용 전에는 클라이언트가 보냄)
    private String content; // 댓글 내용

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
