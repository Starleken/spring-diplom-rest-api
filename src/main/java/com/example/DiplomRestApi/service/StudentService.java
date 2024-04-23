package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.student.StudentActivityDto;
import com.example.DiplomRestApi.dto.student.StudentCreateDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.dto.student.StudentUpdateDto;
import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentFullDto> findAll();

    List<StudentActivityDto> findAllWithActivities();

    List<StudentActivityDto> findByGroupWithActivities(long groupId);

    StudentFullDto findById(Long id);

    StudentFullDto create(StudentCreateDto createDto);

    StudentFullDto update(StudentUpdateDto updateDto);

    List<StudentFullDto> findStudentsByGroup(Long groupId);

    StudentFullDto findStudentByUser(Long userId);

    void deleteById(Long id);
}
