package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnFullDto;
import com.example.DiplomRestApi.entity.InnEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InnMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    InnEntity mapToEntity(InnCreateDto createDto);

    InnFullDto mapToDto(InnEntity entity);
}
