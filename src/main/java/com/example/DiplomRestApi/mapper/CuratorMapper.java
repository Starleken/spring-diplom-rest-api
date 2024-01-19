package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuratorMapper {

    CuratorFullDto mapToDto(CuratorEntity entity);
}
