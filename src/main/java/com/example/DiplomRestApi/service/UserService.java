package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.User;
import com.example.DiplomRestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void create(User user){
        userRepository.save(user);
    }
}
