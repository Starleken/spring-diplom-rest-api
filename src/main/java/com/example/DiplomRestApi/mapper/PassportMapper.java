package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.entity.PassportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface PassportMapper {

    public List<PassportFullDto> mapToDtoList(List<PassportEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    public PassportEntity mapToEntity(PassportCreateDto dto);

    public PassportFullDto mapToDto(PassportEntity entity);
}
