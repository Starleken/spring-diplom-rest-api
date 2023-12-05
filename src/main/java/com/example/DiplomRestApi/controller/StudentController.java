package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> findAll(){
        return studentService.findAll();
    }

    @GetMapping(path = "/group")
    public List<StudentEntity> findStudentsByGroup(@RequestParam Long groupId){
        return studentService.findStudentsByGroup(groupId);
    }

    @GetMapping(path = "/user")
    public StudentEntity findStudentByUser(@RequestParam Long userId){
        return studentService.findStudentByUser(userId);
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentEntity studentEntity){
        return studentService.save(studentEntity);
    }

    @PutMapping
    public StudentEntity update(@RequestBody StudentEntity studentEntity){
        return studentService.update(studentEntity);
    }
}
