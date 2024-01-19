package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyFullDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;

import java.util.List;

public interface MedicalPolicyService {

    List<MedicalPolicyFullDto> findAll();

    List<MedicalPolicyFullDto> findAllByStudent(Long studentId);

    MedicalPolicyFullDto create(MedicalPolicyCreateDto createDto);

    MedicalPolicyFullDto update(MedicalPolicyUpdateDto updateDto);

    void deleteById(Long id);
}
