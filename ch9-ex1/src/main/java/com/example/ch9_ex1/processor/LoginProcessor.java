package com.example.ch9_ex1.processor;

import com.example.ch9_ex1.service.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    private String username;
    private String password;

    public boolean login(){
        boolean logResult=false;

        // 저장소 정보 비교 후
        // true 시 반환 및 세션 호출 후 사용자에 대한 세션 유지
        // false 시 log Result = false 반환
        if("dh6559".equals(this.getUsername()) && "password".equals(this.getPassword())){
            logResult = true;
            // 세션 스코프 호출로 세션에 해당 사용자 Session 유지
            // 요청 스코프(사용자 검증) -> 세션 스코프(사용자 로그인 한 정보를 세션에 유지)
            loggedUserManagementService.setUsername(username);
        }
        return logResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
