package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
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

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        Optional<UserEntity> findedUser = userRepository.findByLoginAndPassword(login, password);

        //TODO
        if (findedUser.isEmpty()){
            throw new EntityNotFoundException("User is not found");
        }
        return findedUser.get();
    }
}
