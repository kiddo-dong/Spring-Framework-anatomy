package com.example.ch7_ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/sub")
    public String sub(@RequestParam(required = false) String color,
                      @RequestParam(required = false) String name,
                      Model model){

        model.addAttribute("color",color);
        model.addAttribute("name", name);
        return "sub.html";
    }
/*
    @RequestMapping("/sub/{color}")
    public String sub_path(@PathVariable String color,
                           @RequestParam String name,
                           Model model){

        model.addAttribute("name", name);
        return "sub.html";
    }
 */
}
