package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyFullDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.service.MedicalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "medicalPolicy")
public class MedicalPolicyController {

    private final MedicalPolicyService medicalPolicyService;

    @GetMapping()
    public ResponseEntity<List<MedicalPolicyFullDto>> findAll(){
        return new ResponseEntity<>(medicalPolicyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<List<MedicalPolicyFullDto>> findAllByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(medicalPolicyService.findAllByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MedicalPolicyFullDto> create(@ModelAttribute MedicalPolicyCreateDto createDto){
        return new ResponseEntity<>(medicalPolicyService.create(createDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MedicalPolicyFullDto> update(@ModelAttribute MedicalPolicyUpdateDto updateDto){
        return new ResponseEntity<>(medicalPolicyService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        medicalPolicyService.deleteById(id);
    }
}
