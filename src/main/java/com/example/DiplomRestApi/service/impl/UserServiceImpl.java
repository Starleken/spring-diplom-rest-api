package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.login.LoginRequestDto;
import com.example.DiplomRestApi.dto.login.LoginResponseDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenRequestDto;
import com.example.DiplomRestApi.dto.token.RefreshTokenResponseDto;
import com.example.DiplomRestApi.dto.user.UserCreateDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import com.example.DiplomRestApi.entity.RoleEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.UserMapper;
import com.example.DiplomRestApi.repository.RoleRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.TokenService;
import com.example.DiplomRestApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper mapper;
    private final RoleRepository roleRepository;
    private final TokenService tokenService;

    public List<UserFullDto> findAll(){
        List<UserEntity> entities = userRepository.findAll();

        List<UserFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public UserFullDto findByLoginAndPassword(String login, String password) {
        Optional<UserEntity> findedUser = userRepository.findByLoginAndPassword(login, password);

        if (findedUser.isEmpty()){
            throw new EntityNotFoundException("User is not found");
        }

        return mapper.mapToDto(findedUser.get());
    }

    @Override
    public UserFullDto create(UserCreateDto createDto) {
        var user = mapper.mapToEntity(createDto);
        RoleEntity role = roleRepository.findById(createDto.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role is not found"));

        user.setRole(role);

        return mapper.mapToDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public LoginResponseDto login(LoginRequestDto loginDto) {
        var found = userRepository.findByLogin(loginDto.getLogin())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var token = tokenService.generateRefreshToken(found.getId());

        return LoginResponseDto.builder()
                .userId(found.getId())
                .accessToken(tokenService.generateAccessToken(found.getId()))
                .refreshToken(token)
                .build();
    }

    @Override
    public RefreshTokenResponseDto refresh(RefreshTokenRequestDto refreshDto) {
        var refreshToken = refreshDto.getRefreshToken();

        return tokenService.refresh(refreshToken);
    }
}
