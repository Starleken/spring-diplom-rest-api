package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.service.MedicalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "medicalPolicy")
public class MedicalPolicyController {

    private final MedicalPolicyService medicalPolicyService;

    @GetMapping()
    public List<MedicalPolicyEntity> findAll(){
        return medicalPolicyService.findAll();
    }

    @GetMapping("/student")
    public List<MedicalPolicyEntity> findAllByStudent(@RequestParam Long studentId){
        return medicalPolicyService.findAllByStudent(studentId);
    }

    @PostMapping()
    public MedicalPolicyEntity create(@ModelAttribute MedicalPolicyCreateDto createDto){
        return medicalPolicyService.create(createDto);
    }

    @PutMapping()
    public MedicalPolicyEntity update(@ModelAttribute MedicalPolicyUpdateDto updateDto){
        return medicalPolicyService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        medicalPolicyService.deleteById(id);
    }
}
