package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.login.LoginRequestDto;
import com.example.DiplomRestApi.dto.login.LoginResponseDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenRequestDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenResponseDto;
import com.example.DiplomRestApi.dto.user.UserCreateDto;
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

    @PostMapping
    public ResponseEntity<UserFullDto> create(@RequestBody UserCreateDto createDto) {
        log.info("Create user request: {}", createDto);
        var entity = userService.create(createDto);
        log.info("Created user: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginDto) {
        log.info("Login requested. Email: {}", loginDto.getLogin());
        var response = userService.login(loginDto);
        log.info("User is logged in. Id: {}", response.getUserId());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/tokens/refresh")
    public ResponseEntity<RefreshTokenResponseDto> refresh(@RequestBody RefreshTokenRequestDto refreshDto) {
        log.info("Refresh requested");
        var response = userService.refresh(refreshDto);
        log.info("Token refreshed");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
