package com.example.UserMVC_gptQ.controller;

import com.example.UserMVC_gptQ.domain.User;
import com.example.UserMVC_gptQ.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> AllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public String UserByid(@RequestParam int id,
                         Model model){
        userService.getUserById(id);
        return "/user";
    }
}
