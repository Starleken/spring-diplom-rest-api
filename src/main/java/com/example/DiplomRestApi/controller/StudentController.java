package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.student.StudentCreateDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.dto.student.StudentUpdateDto;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentFullDto>> findAll() {
        log.info("Find all students requested");
        var entities = studentService.findAll();
        log.info("The number of students found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentFullDto> findById(@PathVariable Long id) {
        log.info("Find student by id requested. id: {}", id);
        var entity = studentService.findById(id);
        log.info("student found by id {}: {}", id, entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping(path = "/group")
    public ResponseEntity<List<StudentFullDto>> findStudentsByGroup(@RequestParam Long groupId) {
        log.info("Find students by group requested. GroupId: {}", groupId);
        var entities = studentService.findStudentsByGroup(groupId);
        log.info("The number of students by groupId {} found: {}", groupId, entities);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<StudentFullDto> findStudentByUser(@RequestParam Long userId) {
        log.info("Find student by user requested. UserId: {}", userId);
        var entity = studentService.findStudentByUser(userId);
        log.info("Student found by userId {}: {}", userId, entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentFullDto> create(@RequestBody StudentCreateDto createDto) {
        log.info("Create student request: {}", createDto);
        var entity = studentService.create(createDto);
        log.info("Created student: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentFullDto> update(@RequestBody StudentUpdateDto updateDto) {
        log.info("Update student request: {}", updateDto);
        var entity = studentService.update(updateDto);
        log.info("Updated student: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Delete student by id requested. Id: {}", id);
        studentService.deleteById(id);
        log.info("Student deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
