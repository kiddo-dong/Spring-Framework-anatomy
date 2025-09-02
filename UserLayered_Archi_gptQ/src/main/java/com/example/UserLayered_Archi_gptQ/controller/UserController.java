package com.example.UserLayered_Archi_gptQ.controller;

import com.example.UserLayered_Archi_gptQ.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(@RequestParam String name,
                          @RequestParam String email,
                          Model model){
        userService.addUser(name, email);
        return "redirect:/users";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String AllUsers(Model model){
        model.addAttribute("userList", userService.getAllUsers());
        return "/users";
    }

}