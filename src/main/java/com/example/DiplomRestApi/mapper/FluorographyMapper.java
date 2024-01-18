package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.entity.FluorographyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FluorographyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    FluorographyEntity mapToEntity(FluorographyCreateDto createDto);
}
