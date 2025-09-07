package com.example.ch9_ex1.controller;

import com.example.ch9_ex1.processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//1. HTTP 요청마다 생성 후 사라지는 요청 스코프로 사용자 검증
//2. 세션 스코프로 사용자 상태 유지 (서버 메모리에 올림 -> 브라우저에 쿠키 전달)
//3. 테스트 및 구현

// 현재 기본 Bean인 Singleton Bean으로 설정됨
//
@Controller
public class Logincontroller {

    //스프링 컨텍스트에 원본 빈 인스턴스가 아닌 proxy 객체가 주입됨
    // RequestBean
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

        // 요청 스코프를 사용하는 이 시점에서 원본 인스턴스가 생성됨.
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            // 저장된 사용자 정보가 일치 시 login 및 main 페이지 리다이렉트(이동)
            model.addAttribute("message", "You are now logged in.");
            return "redirect:/main";
        } else {
            // 사용자 로그인 실패시 Message 출력(view)
            model.addAttribute("message", "Login failed!");
            return "login";
        }
    }
}
