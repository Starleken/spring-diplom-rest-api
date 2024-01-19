package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyFullDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalPolicyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "imageURL", ignore = true)
    MedicalPolicyEntity mapToEntity(MedicalPolicyCreateDto createDto);

    MedicalPolicyFullDto mapToDto(MedicalPolicyEntity entity);
}
