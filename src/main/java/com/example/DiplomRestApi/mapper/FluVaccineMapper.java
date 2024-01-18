package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FluVaccineMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    FluVaccineEntity mapToEntity(FluVaccineCreateDto createDto);
}
