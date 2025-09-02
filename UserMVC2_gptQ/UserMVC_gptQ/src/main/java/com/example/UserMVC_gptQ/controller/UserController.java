package com.example.UserMVC_gptQ.controller;

import com.example.UserMVC_gptQ.domain.User;
import com.example.UserMVC_gptQ.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class UserController {
    private final Map<String,UserService> userServiceMap;

    Logger logger = Logger.getLogger(UserController.class.getName());

    public UserController(Map<String, UserService> userServiceMap) {
        this.userServiceMap = userServiceMap;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute User user,
                           String type,
                           Model model){
        UserService userService = userServiceMap.get(type);
        if(userService != null){
            userService.addUser(user);
        } else {
            logger.info("not instance type of Implements");
        }
        return "redirect:/users"; // 등록된 user 리다이렉트
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String AllUsers(String type, Model model){
        UserService userService = userServiceMap.get(type);
        if(userService != null){
            model.addAttribute("users", userService.AllUsers());
        } else {
            logger.info("not instance type of Implements");
        }
        return "/users";
    }
}
