package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnFullDto;
import com.example.DiplomRestApi.dto.inn.InnUpdateDto;
import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.InnMapper;
import com.example.DiplomRestApi.repository.InnRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.ImageService;
import com.example.DiplomRestApi.service.InnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InnServiceImpl implements InnService {

    private final InnRepository innRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final InnMapper mapper;

    @Override
    public List<InnFullDto> findAll() {
        List<InnEntity> entities = innRepository.findAll();

        List<InnFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public List<InnFullDto> findAllByStudent(Long studentId){
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }

        List<InnEntity> entities = innRepository.findAllByStudent(findedStudent.get());

        List<InnFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public InnFullDto create(InnCreateDto createDto) {
        InnEntity inn = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("student is not found");
        }
        inn.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        inn.setImageURL(imageUrl);

        InnEntity saved = innRepository.save(inn);
        return mapper.mapToDto(saved);
    }

    @Override
    public InnFullDto update(InnUpdateDto updateDto) {
        Optional<InnEntity> findedEntity = innRepository
                .findById(updateDto.getId());

        if (findedEntity.isEmpty()){
            throw new EntityNotFoundException("inn is not found");
        }

        InnEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(updateDto.getNumber());

        if (updateDto.getImage() != null){
            imageService.deleteImage(entityToUpdate.getImageURL());
            String imageUrl = imageService.saveImage(updateDto.getImage());
            entityToUpdate.setImageURL(imageUrl);
        }

        InnEntity updated = innRepository.save(entityToUpdate);
        return mapper.mapToDto(updated);
    }

    @Override
    public void deleteById(Long id) {
        Optional<InnEntity> inn = innRepository.findById(id);

        if (inn.isEmpty()){
            throw new EntityNotFoundException("Inn is not found");
        }

        imageService.deleteImage(inn.get().getImageURL());
        innRepository.deleteById(id);
    }
}
