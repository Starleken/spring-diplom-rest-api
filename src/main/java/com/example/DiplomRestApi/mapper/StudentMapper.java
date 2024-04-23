package com.example.DiplomRestApi.mapper;

import com.example.DiplomRestApi.dto.student.StudentActivityDto;
import com.example.DiplomRestApi.dto.student.StudentCreateDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, GroupMapper.class, EducationFormMapper.class})
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationAddress", ignore = true)
    @Mapping(target = "residentialAddress", ignore = true)
    @Mapping(target = "educationForm", ignore = true)
    @Mapping(target = "group", ignore = true)
    @Mapping(source = "user", target = "user")
    StudentEntity mapToEntity(StudentCreateDto createDto);

    StudentFullDto mapToDto(StudentEntity entity);
    StudentActivityDto mapToWithActivityDto(StudentEntity entity);
}
