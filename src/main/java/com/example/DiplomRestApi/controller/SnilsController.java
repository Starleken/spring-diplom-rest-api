package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsFullDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("snils")
@RequiredArgsConstructor
public class SnilsController {

    private final SnilsService snilsService;

    @GetMapping()
    public ResponseEntity<List<SnilsFullDto>> findAll(){
        return new ResponseEntity<>(snilsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<SnilsFullDto>> findAllByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(snilsService.findAllByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SnilsFullDto> create(@ModelAttribute SnilsCreateDto createDto){
        return new ResponseEntity<>(snilsService.create(createDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SnilsFullDto> update(@ModelAttribute SnilsUpdateDto updateDto){
        return new ResponseEntity<>(snilsService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        snilsService.delete(id);
    }
}
