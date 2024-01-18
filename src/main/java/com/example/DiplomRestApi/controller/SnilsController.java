package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("snils")
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
    public SnilsEntity create(@ModelAttribute SnilsCreateDto createDto){
        return snilsService.create(createDto);
    }

    @PutMapping
    public SnilsEntity update(@ModelAttribute SnilsUpdateDto updateDto){
        return snilsService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        snilsService.delete(id);
    }
}
