package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.service.FluorographyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fluorographies")
@RequiredArgsConstructor
@Slf4j
public class FluorographyController {

    private final FluorographyService fluorographyService;

    @GetMapping
    public ResponseEntity<List<FluorographyFullDto>> findAll() {
        log.info("Find all fluorographies requested");
        var entities = fluorographyService.findAll();
        log.info("The number of fluorographies found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<FluorographyFullDto> findByStudent(@RequestParam Long studentId) {
        log.info("Find fluorography by student requested. StudentId: {}", studentId);
        var entity = fluorographyService.findByStudent(studentId);
        log.info("Fluorography found by studentId {}: {}", studentId, entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FluorographyFullDto> create(@ModelAttribute FluorographyCreateDto createDto) {
        log.info("Create fluorography request: {}", createDto);
        var entity = fluorographyService.create(createDto);
        log.info("Created fluorography: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<FluorographyFullDto> update(@ModelAttribute FluorographyUpdateDto updateDto) {
        log.info("Update fluorography request: {}", updateDto);
        var entity = fluorographyService.update(updateDto);
        log.info("Updated fluorography: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("Delete fluorography by id requested. Id: {}", id);
        fluorographyService.delete(id);
        log.info("Fluorography deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
