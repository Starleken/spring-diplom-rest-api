package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;
import com.example.DiplomRestApi.service.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "passports")
@RequiredArgsConstructor
@Slf4j
public class PassportController {

    private final PassportService passportService;

    @GetMapping
    public ResponseEntity<List<PassportFullDto>> findAll() {
        log.info("Find all passports requested");
        var entities = passportService.findAll();
        log.info("The number of passports found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<PassportFullDto> findByStudent(@RequestParam long studentId) {
        log.info("Find passport by student requested. StudentId: {}", studentId);
        var entity = passportService.findByStudent(studentId);
        log.info("Passport found by studentId {}: {}", studentId, entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PassportFullDto> create(@ModelAttribute PassportCreateDto createDto) {
        log.info("Create passport request: {}", createDto);
        var entity = passportService.create(createDto);
        log.info("Created passport: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PassportFullDto> update(@ModelAttribute PassportUpdateDto updateDto) {
        log.info("Update passport request: {}", updateDto);
        var entity = passportService.update(updateDto);
        log.info("Updated passport: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Delete passport by id requested. Id: {}", id);
        passportService.deleteById(id);
        log.info("Passport deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
