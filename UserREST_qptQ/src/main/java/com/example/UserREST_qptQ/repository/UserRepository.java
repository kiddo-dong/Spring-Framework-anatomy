package com.example.UserREST_qptQ.repository;

import com.example.UserREST_qptQ.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    // 사용자 추가
    public void addUser(User user){
        users.add(user);
    }

    // 사용자 조회 (id로)
    public Optional<User> findById(String id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst(); // Optional<User> 반환
    }

    // 사용자 업데이트 (이름과 이메일만 예시)
    public boolean updateUser(String id, String newName, String newEmail) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> {
                    user.setName(newName);
                    user.setEmail(newEmail);
                    return true;
                }).orElse(false); // 없으면 false 반환
    }

    // 사용자 삭제
    public boolean deleteUser(String id) {
        Optional<User> userToDelete = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        return userToDelete.map(users::remove).orElse(false);
    }

    // 모든 사용자 조회
    public List<User> getAllUsers(){
        return users;
    }
}
