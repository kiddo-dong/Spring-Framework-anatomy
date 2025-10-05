package com.example.Session_Cookie_Board.users.domain;

import java.time.LocalDateTime;

public class UserDto {
    private String userId;   // PK
    private String username;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
