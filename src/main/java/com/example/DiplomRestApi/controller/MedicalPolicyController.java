package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.service.MedicalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/medicalPolicy")
public class MedicalPolicyController {

    private final MedicalPolicyService medicalPolicyService;

    @GetMapping()
    public List<MedicalPolicyEntity> findAll(){
        return medicalPolicyService.findAll();
    }

    @GetMapping("/student")
    public List<MedicalPolicyEntity> findAllByStudent(Long studentId){
        return medicalPolicyService.findAllByStudent(studentId);
    }

    @PostMapping()
    public MedicalPolicyEntity create(MedicalPolicyEntity entity){
        return medicalPolicyService.create(entity);
    }
}
