package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.User;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        Optional<User> findedUser = userRepository.findByLoginAndPassword(login, password);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }
        return findedUser.get();
    }
}
