package com.example.postMVC_gptQ.service;

import com.example.postMVC_gptQ.domain.Post;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post p){
        posts.add(p);
    }

    public List<Post> findAll(){
        return posts;
    }

}
