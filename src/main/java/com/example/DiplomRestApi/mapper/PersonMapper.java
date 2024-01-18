package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.person.PersonCreateDto;
import com.example.DiplomRestApi.dto.person.PersonFullDto;
import com.example.DiplomRestApi.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    PersonEntity mapToEntity(PersonCreateDto createDto);

    PersonFullDto mapToDto(PersonEntity entity);
}
