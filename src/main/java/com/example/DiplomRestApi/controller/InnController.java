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
@Slf4j
public class InnController {

    private final InnService innService;

    @GetMapping
    public ResponseEntity<List<InnFullDto>> findAll() {
        log.info("Find all inn requested");
        var entities = innService.findAll();
        log.info("The number of inn found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<List<InnFullDto>> findAllByStudent(Long studentId) {
        log.info("Find inn by student requested. StudentId: {}", studentId);
        var entities = innService.findAllByStudent(studentId);
        log.info("The number of inn by studentId {} found: {}", studentId, entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InnFullDto> create(@ModelAttribute InnCreateDto createDto) {
        log.info("Create inn request: {}", createDto);
        var entity = innService.create(createDto);
        log.info("Created inn: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<InnFullDto> update(@ModelAttribute InnUpdateDto updateDto) {
        log.info("Update inn request: {}", updateDto);
        var entity = innService.update(updateDto);
        log.info("Updated inn: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("Delete inn by id requested. Id: {}", id);
        innService.deleteById(id);
        log.info("Inn deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
