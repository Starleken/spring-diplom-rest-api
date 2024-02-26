package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.entity.ActivityEntity;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, ActivityTypeMapper.class, ActivityLevelMapper.class})
public interface ActivityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    ActivityEntity mapToEntity(ActivityCreateDto createDTO);

    @Mapping(target = "imageUrl", source = "imageURL")
    ActivityFullDto mapToDto(ActivityEntity entity);
}
