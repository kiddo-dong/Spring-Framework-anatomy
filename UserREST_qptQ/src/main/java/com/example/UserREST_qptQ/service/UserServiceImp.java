package com.example.UserREST_qptQ.service;

import com.example.UserREST_qptQ.domain.User;
import com.example.UserREST_qptQ.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(User user) {
        userRepository.addUser(user);
        return "user add successed";
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(String id, String newName, String newEmail) {
        boolean updated = userRepository.updateUser(id, newName, newEmail);
        if(!updated){
            throw new RuntimeException("User not found with id: " + id);
        }
        return userRepository.findById(id).get(); // Optional이지만 여기서는 존재 확정
    }

    @Override
    public String deleteUser(String id) {
        boolean deleteUser = userRepository.deleteUser(id);
        if(deleteUser == true){
            return "user delete successed";
        } else {
            return "non existent User";
        }
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
