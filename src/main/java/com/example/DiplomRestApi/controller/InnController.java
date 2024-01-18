package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnUpdateDto;
import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.service.InnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inn")
@RequiredArgsConstructor
@Slf4j
public class InnController {

    private final InnService innService;

    @GetMapping()
    public List<InnEntity> findAll(){
        return innService.findAll();
    }

    @GetMapping("/student")
    public List<InnEntity> findAllByStudent(Long studentId){
        return innService.findAllByStudent(studentId);
    }

    @PostMapping
    public InnEntity create(@ModelAttribute InnCreateDto createDto){
        return innService.create(createDto);
    }

    @PutMapping
    public InnEntity update(@ModelAttribute InnUpdateDto updateDto){
        return innService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        innService.deleteById(id);
    }
}
