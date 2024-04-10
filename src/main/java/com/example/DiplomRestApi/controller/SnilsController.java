package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsFullDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("snilses")
@RequiredArgsConstructor
@Slf4j
public class SnilsController {

    private final SnilsService snilsService;

    @GetMapping
    public ResponseEntity<List<SnilsFullDto>> findAll() {
        log.info("Find all snilses requested");
        var entities = snilsService.findAll();
        log.info("The number of snilses found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<SnilsFullDto>> findAllByStudent(@RequestParam Long studentId) {
        log.info("Find snilses by student requested. StudentId: {}", studentId);
        var entities = snilsService.findAllByStudent(studentId);
        log.info("The number of snilses by studentId {} found: {}", studentId, entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SnilsFullDto> create(@ModelAttribute SnilsCreateDto createDto) {
        log.info("Create snils request: {}", createDto);
        var entity = snilsService.create(createDto);
        log.info("Created snils: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SnilsFullDto> update(@ModelAttribute SnilsUpdateDto updateDto) {
        log.info("Update snils request: {}", updateDto);
        var entity = snilsService.update(updateDto);
        log.info("Updated snils: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("Delete snils by id requested. Id: {}", id);
        snilsService.delete(id);
        log.info("Snils deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
