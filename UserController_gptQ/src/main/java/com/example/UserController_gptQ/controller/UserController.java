package com.example.UserController_gptQ.controller;

import com.example.UserController_gptQ.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/")
    public User getUser(User user){
        return user;
    }
}
