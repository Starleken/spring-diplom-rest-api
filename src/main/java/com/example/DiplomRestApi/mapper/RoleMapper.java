package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.role.RoleFullDto;
import com.example.DiplomRestApi.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleFullDto mapToDto(RoleEntity entity);
}
