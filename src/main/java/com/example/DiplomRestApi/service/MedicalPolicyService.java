package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;

import java.util.List;

public interface MedicalPolicyService {

    List<MedicalPolicyEntity> findAll();

    List<MedicalPolicyEntity> findAllByStudent(Long studentId);

    MedicalPolicyEntity create(MedicalPolicyCreateDto createDto);

    MedicalPolicyEntity update(MedicalPolicyUpdateDto updateDto);

    void deleteById(Long id);
}
