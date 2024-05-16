package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.token.RefreshTokenResponseDto;
import io.jsonwebtoken.Claims;

public interface TokenService {

    String generateAccessToken(long userId);
    String generateRefreshToken(long userId);
    void validateAccessToken(String token);
    void validateRefreshToken(String token);
    RefreshTokenResponseDto refresh(String token);
    Claims getAccessClaims(String token);
}
