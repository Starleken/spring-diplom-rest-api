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
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentFullDto>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentFullDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/group")
    public ResponseEntity<List<StudentFullDto>> findStudentsByGroup(@RequestParam Long groupId){
        return new ResponseEntity<>(studentService.findStudentsByGroup(groupId), HttpStatus.OK);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<StudentFullDto> findStudentByUser(@RequestParam Long userId){
        return new ResponseEntity<>(studentService.findStudentByUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentFullDto> create(@RequestBody StudentCreateDto createDto){
        return new ResponseEntity<>(studentService.create(createDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentFullDto> update(@RequestBody StudentUpdateDto updateDto){
        return new ResponseEntity<>(studentService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }
}
