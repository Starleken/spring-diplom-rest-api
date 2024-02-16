package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.student.StudentCreateDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.dto.student.StudentUpdateDto;
import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    public List<StudentFullDto> findAll();

    public StudentFullDto findById(Long id);

    public StudentFullDto create(StudentCreateDto createDto);

    public StudentFullDto update(StudentUpdateDto updateDto);

    public List<StudentFullDto> findStudentsByGroup(Long groupId);

    public StudentFullDto findStudentByUser(Long userId);

    public void deleteById(Long id);
}
