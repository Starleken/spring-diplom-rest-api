package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    public List<StudentEntity> findAll();

    public StudentEntity save(StudentEntity studentEntity);

    public StudentEntity update(StudentEntity studentEntity);

    public List<StudentEntity> findStudentsByGroup(Long groupId);

    public StudentEntity findStudentByUser(Long userId);
}
