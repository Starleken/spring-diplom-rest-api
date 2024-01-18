package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupFullDto mapToDto(GroupEntity entity);
}
