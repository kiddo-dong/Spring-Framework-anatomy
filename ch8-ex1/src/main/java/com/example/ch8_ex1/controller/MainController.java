package com.example.ch8_ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

@Controller
public class MainController {
    /*
    // Model 객체를 사용한 동적 view mapping
    // Model 객체에 직접 매개변수의 값 대입(하드 코딩)
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("username", "dh");
        model.addAttribute("color", "red");
        return "home.html";
    }
     */

    /*
    // @RequestParam을 이용한 매개변수로 동적 view mapping
    // view의 파라미터명과 매개변수명 동일 mapping
    @RequestMapping("/home")
    public String home(@RequestParam(required = false) String name,
                       @RequestParam(required = false) String color,
                       Model model){
        model.addAttribute("name", name);
        model.addAttribute("color", color);
        return "home.html";
    }
     */

    // 경로 변수를 이용한 동적 view mapping
    // 필수 입력 매개변수 시 사용
    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color,
                       Model model
    ){
        model.addAttribute("name", "dh");
        model.addAttribute("color", color);
        return "home.html";
    }
}
