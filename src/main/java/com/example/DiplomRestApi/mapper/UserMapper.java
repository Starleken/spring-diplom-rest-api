package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.user.UserCreateDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import com.example.DiplomRestApi.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserEntity mapToEntity(UserCreateDto user);

    UserFullDto mapToDto(UserEntity user);
}
