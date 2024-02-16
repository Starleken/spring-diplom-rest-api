package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, GroupMapper.class})
public interface CuratorMapper {

    CuratorFullDto mapToDto(CuratorEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "group", ignore = true)
    @Mapping(source = "user", target = "user")
    CuratorEntity mapToEntity(CuratorCreateDto createDto);
}
