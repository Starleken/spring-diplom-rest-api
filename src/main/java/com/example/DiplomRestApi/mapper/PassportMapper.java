package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.entity.PassportEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    public List<PassportFullDTO> mapToDtoList(List<PassportEntity> entities);

    public PassportEntity mapToEntity(PassportCreateDTO dto);

    public PassportFullDTO mapToDto(PassportEntity entity);
}
