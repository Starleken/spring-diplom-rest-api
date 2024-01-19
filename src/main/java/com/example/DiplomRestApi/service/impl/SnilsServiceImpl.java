package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsFullDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.SnilsMapper;
import com.example.DiplomRestApi.repository.SnilsRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.ImageService;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SnilsServiceImpl implements SnilsService {

    private final SnilsRepository snilsRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final SnilsMapper mapper;

    @Override
    public List<SnilsFullDto> findAll() {
        List<SnilsEntity> entities = snilsRepository.findAll();

        List<SnilsFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Transactional
    @Override
    public List<SnilsFullDto> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        List<SnilsEntity> entities = snilsRepository.findAllByStudent(findedStudent.get());

        List<SnilsFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public SnilsFullDto create(SnilsCreateDto createDto) {
        SnilsEntity snils = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }
        snils.setStudent(findedStudent.get());

        String imageURL = imageService.saveImage(createDto.getImage());
        snils.setImageURL(imageURL);

        SnilsEntity saved = snilsRepository.save(snils);
        return mapper.mapToDto(saved);
    }

    @Override
    public SnilsFullDto update(SnilsUpdateDto updateDto) {
        Optional<SnilsEntity> findedEntity = snilsRepository
                .findById(updateDto.getId());

        //TODO
        if (findedEntity.isEmpty()){
            throw new EntityNotFoundException("Snils is not found");
        }

        SnilsEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(updateDto.getNumber());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            entityToUpdate.setImageURL(imageUrl);
        }

        SnilsEntity updated = snilsRepository.save(entityToUpdate);
        return mapper.mapToDto(updated);
    }

    @Override
    public void delete(Long id) {
        Optional<SnilsEntity> snils = snilsRepository.findById(id);

        if (snils.isEmpty()){
            throw new EntityNotFoundException("Snils is not found");
        }

        imageService.deleteImage(snils.get().getImageURL());
        snilsRepository.deleteById(id);
    }
}
