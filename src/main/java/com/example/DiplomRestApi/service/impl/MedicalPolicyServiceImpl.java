package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.MedicalPolicyRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.MedicalPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalPolicyServiceImpl implements MedicalPolicyService {

    private final MedicalPolicyRepository medicalPolicyRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<MedicalPolicyEntity> findAll() {
        return medicalPolicyRepository.findAll();
    }

    @Override
    public List<MedicalPolicyEntity> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return medicalPolicyRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public MedicalPolicyEntity create(MedicalPolicyEntity entity) {
        return medicalPolicyRepository.save(entity);
    }

    @Override
    public MedicalPolicyEntity update(MedicalPolicyEntity entity) {
        Optional<MedicalPolicyEntity> findedEntity = medicalPolicyRepository.
                findById(entity.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        MedicalPolicyEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(entity.getNumber());
        entityToUpdate.setImageURL(entity.getImageURL());

        return medicalPolicyRepository.save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        //TODO
        medicalPolicyRepository.deleteById(id);
    }
}
