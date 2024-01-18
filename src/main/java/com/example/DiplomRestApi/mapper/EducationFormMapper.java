package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.entity.EducationFormEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationFormMapper {

    EducationFormFullDto mapToDto(EducationFormEntity entity);
}
