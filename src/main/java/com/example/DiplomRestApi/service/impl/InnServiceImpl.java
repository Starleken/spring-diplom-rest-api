package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
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

@Service
@RequiredArgsConstructor
public class InnServiceImpl implements InnService {

    private final InnRepository innRepository;
    private final StudentRepository studentRepository;

    private final ImageService imageService;

    private final InnMapper mapper;

    @Override
    public List<InnEntity> findAll() {
        return innRepository.findAll();
    }

    @Override
    public List<InnEntity> findAllByStudent(Long studentId){
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("Student is not found");
        }

        return innRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public InnEntity create(InnCreateDto createDto) {
        InnEntity inn = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(
                createDto.getStudentId());

        if (findedStudent.isEmpty()){
            throw new EntityNotFoundException("student is not found");
        }
        inn.setStudent(findedStudent.get());

        String imageUrl = imageService.saveImage(createDto.getImage());
        inn.setImageURL(imageUrl);

        return innRepository.save(inn);
    }

    @Override
    public InnEntity update(InnUpdateDto updateDto) {
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

        return innRepository.save(entityToUpdate);
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
