package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/snils")
@RequiredArgsConstructor
public class SnilsController {

    private final SnilsService snilsService;

    @GetMapping()
    public List<SnilsEntity> findAll(){
        return snilsService.findAll();
    }

    @GetMapping(path = "/student")
    public List<SnilsEntity> findAllByStudent(@RequestParam Long studentId){
        return snilsService.findAllByStudent(studentId);
    }

    @PostMapping
    public SnilsEntity create(SnilsEntity entity){
        return snilsService.create(entity);
    }
}
