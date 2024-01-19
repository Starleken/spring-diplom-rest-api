package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.user.UserFullDto;
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
    public ResponseEntity<List<UserFullDto>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<UserFullDto> findByLoginAndPassword(@RequestParam String login, @RequestParam String password){
        return new ResponseEntity<>(userService.findByLoginAndPassword(login, password), HttpStatus.OK);
    }

}
