package com.example.ch10_ex1.controller;

// MVC pattern
// Rest API

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// Controller는 기본적으로 View를 반환하게 되어있음. (MVC Pattern)
// ResponseBody 사용시 표현 형식을 다르게 지정 할 수 있음
// RestController의 설계는 REST 아키텍쳐 설계 규칙을 따르므로 다양한 표현 형식 즉, 데이터 자체로 요청이 들어오고 반환이 가능함
// 반환값을 HTTP Response Body로 직렬화

// @Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
    //@ResponseBody
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/ciao")
    //@ResponseBody
    public String ciao(){
       return "Ciao!";
    }
}