package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyFullDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.service.MedicalPolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "medicalPolicies")
@Slf4j
public class MedicalPolicyController {

    private final MedicalPolicyService medicalPolicyService;

    @GetMapping
    public ResponseEntity<List<MedicalPolicyFullDto>> findAll() {
        log.info("Find all medicalPolicies requested");
        var entities = medicalPolicyService.findAll();
        log.info("The number of medicalPolicies found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<MedicalPolicyFullDto> findByStudent(@RequestParam Long studentId) {
        log.info("Find medicalPolicy by student requested. StudentId: {}", studentId);
        var entity = medicalPolicyService.findByStudent(studentId);
        log.info("medicalPolicy found by studentId {}: {}", studentId, entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalPolicyFullDto> create(@ModelAttribute MedicalPolicyCreateDto createDto) {
        log.info("Create medicalPolicy request: {}", createDto);
        var entity = medicalPolicyService.create(createDto);
        log.info("Created medicalPolicy: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MedicalPolicyFullDto> update(@ModelAttribute MedicalPolicyUpdateDto updateDto) {
        log.info("Update medicalPolicy request: {}", updateDto);
        var entity = medicalPolicyService.update(updateDto);
        log.info("Updated medicalPolicy: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("Delete medicalPolicy by id requested. Id: {}", id);
        medicalPolicyService.deleteById(id);
        log.info("MedicalPolicy deleted by id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
