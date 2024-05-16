package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.login.LoginRequestDto;
import com.example.DiplomRestApi.dto.login.LoginResponseDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenRequestDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenResponseDto;
import com.example.DiplomRestApi.dto.user.UserCreateDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import com.example.DiplomRestApi.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserFullDto> findAll();
    UserFullDto findByLoginAndPassword(String login, String password);
    UserFullDto create(UserCreateDto createDto);
    LoginResponseDto login(LoginRequestDto loginDto);
    RefreshTokenResponseDto refresh(RefreshTokenRequestDto refreshDto);
}
