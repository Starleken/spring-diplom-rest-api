package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.User;
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
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }

}
