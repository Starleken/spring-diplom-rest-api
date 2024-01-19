package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyCreateDto;
import com.example.DiplomRestApi.dto.medicalPolicy.MedicalPolicyFullDto;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalPolicyServiceImpl implements MedicalPolicyService {

    private final MedicalPolicyRepository medicalPolicyRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final MedicalPolicyMapper mapper;

    @Override
    public List<MedicalPolicyFullDto> findAll() {
        List<MedicalPolicyEntity> entities = medicalPolicyRepository.findAll();

        List<MedicalPolicyFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<MedicalPolicyFullDto> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<MedicalPolicyEntity> entities = medicalPolicyRepository.findAllByStudent(findedStudent.get());

        List<MedicalPolicyFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public MedicalPolicyFullDto create(MedicalPolicyCreateDto createDto) {
        MedicalPolicyEntity medicalPolicy = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        medicalPolicy.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        medicalPolicy.setImageURL(imageUrl);

        MedicalPolicyEntity saved = medicalPolicyRepository.save(medicalPolicy);
        return mapper.mapToDto(saved);
    }

    @Override
    public MedicalPolicyFullDto update(MedicalPolicyUpdateDto updateDto) {
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

        MedicalPolicyEntity updated = medicalPolicyRepository.save(entityToUpdate);
        return mapper.mapToDto(updated);
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
