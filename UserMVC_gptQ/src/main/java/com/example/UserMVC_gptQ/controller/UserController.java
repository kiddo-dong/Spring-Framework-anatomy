package com.example.UserMVC_gptQ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String ViewUser(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int age,
            Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);

        return "user";
    }
}