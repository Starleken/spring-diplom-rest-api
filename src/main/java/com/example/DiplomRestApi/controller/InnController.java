package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnFullDto;
import com.example.DiplomRestApi.dto.inn.InnUpdateDto;
import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.service.InnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inn")
@RequiredArgsConstructor
public class InnController {

    private final InnService innService;

    @GetMapping()
    public ResponseEntity<List<InnFullDto>> findAll(){
        return new ResponseEntity<>(innService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<List<InnFullDto>> findAllByStudent(Long studentId){
        return new ResponseEntity<>(innService.findAllByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InnFullDto> create(@ModelAttribute InnCreateDto createDto){
        return new ResponseEntity<>(innService.create(createDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<InnFullDto> update(@ModelAttribute InnUpdateDto updateDto){
        return new ResponseEntity<>(innService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        innService.deleteById(id);
    }
}
