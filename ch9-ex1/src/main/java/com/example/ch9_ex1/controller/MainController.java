package com.example.ch9_ex1.controller;

import com.example.ch9_ex1.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// login 성공 시 /login to /main redirect
@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(){
        String username = loggedUserManagementService.getUsername();
        
        if (username == null) {
            return "redirect:/";
        }
        return "main";
    }
}
