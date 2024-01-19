package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineFullDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.FluVaccineMapper;
import com.example.DiplomRestApi.repository.FluVaccineRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.FluVaccineService;
import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FluVaccineServiceImpl implements FluVaccineService {

    private final FluVaccineRepository fluVaccineRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final FluVaccineMapper mapper;

    @Override
    public List<FluVaccineFullDto> findAll() {
        List<FluVaccineEntity> entities = fluVaccineRepository.findAll();

        List<FluVaccineFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<FluVaccineFullDto> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<FluVaccineEntity> entities = fluVaccineRepository.findAllByStudent(findedStudent.get());

        List<FluVaccineFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public FluVaccineFullDto create(FluVaccineCreateDto createDto) {
        FluVaccineEntity fluVaccine = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        fluVaccine.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        fluVaccine.setImageURL(imageUrl);

        FluVaccineEntity saved = fluVaccineRepository.save(fluVaccine);
        return mapper.mapToDto(saved);
    }

    @Override
    public FluVaccineFullDto update(FluVaccineUpdateDto updateDto) {
        Optional<FluVaccineEntity> findedEntity = fluVaccineRepository.
                findById(updateDto.getId());

        if (findedEntity.isEmpty()){
            throw new EntityNotFoundException("FluVaccine is not found");
        }

        FluVaccineEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setCreateDate(updateDto.getCreateDate());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            entityToUpdate.setImageURL(imageUrl);
        }

        FluVaccineEntity updated = fluVaccineRepository.save(entityToUpdate);
        return mapper.mapToDto(updated);
    }

    @Override
    public void delete(Long id) {
        Optional<FluVaccineEntity> fluVaccine = fluVaccineRepository.findById(id);

        if (fluVaccine.isEmpty()){
            throw new EntityNotFoundException("Vaccine is not found");
        }

        imageService.deleteImage(fluVaccine.get().getImageURL());
        fluVaccineRepository.deleteById(id);
    }
}
