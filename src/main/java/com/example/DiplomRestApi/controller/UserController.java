package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAll(){
        return userService.findAll();
    }

    @PostMapping
    public void create(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
    }

    @GetMapping("/auth")
    public UserEntity findByLoginAndPassword(@RequestParam String login, @RequestParam String password){
        return userService.findByLoginAndPassword(login, password);
    }

}
