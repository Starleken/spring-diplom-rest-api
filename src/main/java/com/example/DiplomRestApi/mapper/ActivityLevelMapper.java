package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityLevelMapper {

    ActivityLevelFullDto mapToDto(ActivityLevelEntity entity);
}
