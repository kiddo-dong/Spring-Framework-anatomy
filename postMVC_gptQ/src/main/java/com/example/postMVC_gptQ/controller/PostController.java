package com.example.postMVC_gptQ.controller;

import com.example.postMVC_gptQ.domain.Post;
import com.example.postMVC_gptQ.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    Long id_count= 1L;

    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public String addPost(
            @RequestParam String title,
            @RequestParam String content,
            Model model
            ){

        Post posts = new Post();
        posts.setId(id_count++);
        posts.setTitle(title);
        posts.setContent(content);
        postService.addPost(posts);

        /*
        // 다시 전체 게시글 목록 왜 반환
        // 목록 조회를 위해서 리다이렉트 걸어줌
        model.addAttribute("posts", postService.findAll());
        */

        return "redirect:/posts";
    }

    @RequestMapping("/posts")
    public String viewPost(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "posts";
    }
}