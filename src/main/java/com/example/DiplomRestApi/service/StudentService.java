package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public Student save(Student student);

    public Student update(Student student);
}
