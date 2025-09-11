package com.example.ch9_ex1.controller;

import com.example.ch9_ex1.domain.User;
import com.example.ch9_ex1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute User user){
        userService.addList(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String allUser(Model model){
        model.addAttribute(userService.allUser());
        return "/users";
    }


}
