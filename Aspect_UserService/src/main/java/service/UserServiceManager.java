package service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class UserServiceManager {
    private final Map<String, UserService> userServiceMap;
    private final Logger logger = Logger.getLogger(UserServiceManager.class.getName());

    public UserServiceManager(Map<String, UserService> userServiceMap) {
        this.userServiceMap = userServiceMap;
    }

    public void userServicePublish(String type, String username){
        UserService userService = userServiceMap.get(type);
        if(userService != null) {
            boolean loginInfo = userService.login(username);
            if(loginInfo == true){
                userService.getProfile(username);
            }
        } else {
            logger.warning("404 not page");
        }
    }
}
