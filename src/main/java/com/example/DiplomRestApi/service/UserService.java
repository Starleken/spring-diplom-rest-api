package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserEntity> findAll();

    public UserEntity save(UserEntity userEntity);

    public UserEntity findByLoginAndPassword(String login, String password);
}
