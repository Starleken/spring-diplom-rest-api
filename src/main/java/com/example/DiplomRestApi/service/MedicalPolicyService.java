package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MedicalPolicyService {

    List<MedicalPolicyEntity> findAll();

    List<MedicalPolicyEntity> findAllByStudent(Long studentId);

    MedicalPolicyEntity create(MedicalPolicyEntity entity);

    MedicalPolicyEntity update(MedicalPolicyEntity entity);

    void delete(Long id);
}
