package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.entity.FluorographyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.FluorographyMapper;
import com.example.DiplomRestApi.repository.FluorographyRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.FluorographyService;
import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FluorographyServiceImpl implements FluorographyService {

    private final FluorographyRepository fluorographyRepository;
    private final StudentRepository studentRepository;
    private final ImageService imageService;

    private final FluorographyMapper mapper;

    @Override
    public List<FluorographyFullDto> findAll() {
        List<FluorographyEntity> entities = fluorographyRepository.findAll();

        List<FluorographyFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<FluorographyFullDto> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<FluorographyEntity> entities = fluorographyRepository.findAllByStudent(findedStudent.get());

        List<FluorographyFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public FluorographyFullDto create(FluorographyCreateDto createDto) {
        FluorographyEntity fluorographyToSave = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(createDto.getStudentId());

        if (findedStudent.isEmpty()){
            //TODO
            return null;
        }
        fluorographyToSave.setStudent(findedStudent.get());

        String imageURL = imageService.saveImage(createDto.getImage());
        fluorographyToSave.setImageURL(imageURL);

        FluorographyEntity saved = fluorographyRepository.save(fluorographyToSave);
        return mapper.mapToDto(saved);
    }

    @Override
    public FluorographyFullDto update(FluorographyUpdateDto updateDto) {
        Optional<FluorographyEntity> findedEntity = fluorographyRepository
                .findById(updateDto.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        FluorographyEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(updateDto.getNumber());
        entityToUpdate.setCreateDate(updateDto.getCreateDate());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());

            entityToUpdate.setImageURL(imageUrl);
        }

        FluorographyEntity updated = fluorographyRepository.save(entityToUpdate);
        return mapper.mapToDto(updated);
    }

    @Override
    public void delete(Long id) {
        Optional<FluorographyEntity> fluorography = fluorographyRepository.findById(id);

        if (fluorography.isEmpty()){
            throw new EntityNotFoundException("Fluorography is not found");
        }

        imageService.deleteImage(fluorography.get().getImageURL());
        fluorographyRepository.deleteById(id);
    }
}
