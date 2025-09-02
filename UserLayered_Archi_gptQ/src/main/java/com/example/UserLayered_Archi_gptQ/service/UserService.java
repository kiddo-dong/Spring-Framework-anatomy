package com.example.UserLayered_Archi_gptQ.service;

import com.example.UserLayered_Archi_gptQ.domain.User;
import com.example.UserLayered_Archi_gptQ.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private final UserRepository userRepository;
    Logger logger = Logger.getLogger(UserService.class.getName());
    private Long IdCount=1L;

    //Bean AutoWired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String name, String email){
        User user = new User();
        user.setId(IdCount++);
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);
        logger.info("User saved");
    }

    public List<User> getAllUsers(){
        if(userRepository.findAll() == null) {
            logger.info("UserList is Null");
        }
        return userRepository.findAll();
    }
}
