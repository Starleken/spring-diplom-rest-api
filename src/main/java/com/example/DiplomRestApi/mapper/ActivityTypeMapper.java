package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.activityType.ActivityTypeFullDto;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityTypeMapper {

    ActivityTypeFullDto mapToDto(ActivityTypeEntity entity);
}
