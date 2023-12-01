package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User save(User user);
}
