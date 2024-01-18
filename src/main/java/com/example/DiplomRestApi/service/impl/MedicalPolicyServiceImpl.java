package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyUpdateDto;
import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.MedicalPolicyMapper;
import com.example.DiplomRestApi.repository.MedicalPolicyRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.ImageService;
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

    private final ImageService imageService;

    private final MedicalPolicyMapper mapper;

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
    public MedicalPolicyEntity create(MedicalPolicyCreateDto createDto) {
        MedicalPolicyEntity medicalPolicy = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        medicalPolicy.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        medicalPolicy.setImageURL(imageUrl);

        return medicalPolicyRepository.save(medicalPolicy);
    }

    @Override
    public MedicalPolicyEntity update(MedicalPolicyUpdateDto updateDto) {
        Optional<MedicalPolicyEntity> findedEntity = medicalPolicyRepository.
                findById(updateDto.getId());

        //TODO
        if (findedEntity.isEmpty()){
            throw new EntityNotFoundException("Medical policy is not found");
        }

        MedicalPolicyEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(updateDto.getNumber());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            entityToUpdate.setImageURL(imageUrl);
        }

        return medicalPolicyRepository.save(entityToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Optional<MedicalPolicyEntity> medicalPolicy = medicalPolicyRepository.findById(id);

        if (medicalPolicy.isEmpty()){
            throw new EntityNotFoundException("Medical policy is not found");
        }

        imageService.deleteImage(medicalPolicy.get().getImageURL());
        medicalPolicyRepository.deleteById(id);
    }
}
