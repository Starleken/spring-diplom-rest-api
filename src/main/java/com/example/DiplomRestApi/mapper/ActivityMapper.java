package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    ActivityEntity mapToEntity(ActivityCreateDto createDTO);
}
