package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SnilsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    SnilsEntity mapToEntity(SnilsCreateDto createDto);
}
