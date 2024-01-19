package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.user.UserFullDto;
import com.example.DiplomRestApi.entity.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserFullDto> findAll();

    public UserFullDto findByLoginAndPassword(String login, String password);
}
