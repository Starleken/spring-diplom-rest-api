package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> getAll(){
        return userService.findAll();
    }

    @PostMapping
    public void create(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
    }

    @GetMapping("/auth")
    public ResponseEntity<UserEntity> findByLoginAndPassword(@RequestParam String login, @RequestParam String password){
        return new ResponseEntity<>(userService.findByLoginAndPassword(login, password), HttpStatus.OK);
    }

}
