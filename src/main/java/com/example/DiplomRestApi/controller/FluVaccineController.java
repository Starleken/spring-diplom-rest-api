package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineFullDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.service.FluVaccineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fluVaccines")
@RequiredArgsConstructor
@Slf4j
public class FluVaccineController {

    private final FluVaccineService fluVaccineService;

    @GetMapping
    public ResponseEntity<List<FluVaccineFullDto>> findAll() {
        log.info("Find all fluVaccines requested");
        var entities = fluVaccineService.findAll();
        log.info("The number of fluVaccines found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<FluVaccineFullDto>> findAllByStudent(@RequestParam Long studentId) {
        log.info("Find fluVaccines by student requested. StudentId: {}", studentId);
        var entities = fluVaccineService.findAllByStudent(studentId);
        log.info("The number of fluVaccines by studentId {} found: {}", studentId, entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FluVaccineFullDto> create(@ModelAttribute FluVaccineCreateDto createDto) {
        log.info("Create fluVaccine request: {}", createDto);
        var entity = fluVaccineService.create(createDto);
        log.info("Created fluVaccine: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FluVaccineFullDto> update(@ModelAttribute FluVaccineUpdateDto updateDto) {
        log.info("Update fluVaccine request: {}", updateDto);
        var entity = fluVaccineService.update(updateDto);
        log.info("Updated fluVaccine: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("Delete fluVaccine by id requested. Id: {}", id);
        fluVaccineService.delete(id);
        log.info("FluVaccine deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
