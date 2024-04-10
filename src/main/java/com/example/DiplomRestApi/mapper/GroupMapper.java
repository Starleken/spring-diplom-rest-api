package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.group.GroupCreateDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupFullDto mapToDto(GroupEntity entity);

    @Mapping(target = "id", ignore = true)
    GroupEntity mapToEntity(GroupCreateDto dto);
}
