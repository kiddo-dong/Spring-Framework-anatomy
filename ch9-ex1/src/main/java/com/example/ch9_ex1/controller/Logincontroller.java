package com.example.ch9_ex1.controller;

import com.example.ch9_ex1.processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 현재 기본 Bean인 Singleton Bean으로 설정됨
//
@Controller
public class Logincontroller {

    // 빈의 실 객체가 아닌 proxy 객체가 주입됨
    private final LoginProcessor loginProcessor;

    public Logincontroller(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/") //  / Path 접근 시 /login 으로 redirect
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model){

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            model.addAttribute("message", "You are now logged in.");
        } else {
            model.addAttribute("message", "Login failed!");
        }

        return "login";
    }
}