package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.user.UserFullDto;
import com.example.DiplomRestApi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserFullDto>> findAll() {
        log.info("Find all users requested");
        var entities = userService.findAll();
        log.info("The number of users found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/auth")
    public ResponseEntity<UserFullDto> findByLoginAndPassword(@RequestParam String login, @RequestParam String password) {
        log.info("Find user by login and password requested");
        var entity = userService.findByLoginAndPassword(login, password);
        log.info("User by login and password found: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

}
