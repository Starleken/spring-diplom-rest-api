package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
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

@Service
@Slf4j
@RequiredArgsConstructor
public class FluorographyServiceImpl implements FluorographyService {

    private final FluorographyRepository fluorographyRepository;
    private final StudentRepository studentRepository;
    private final ImageService imageService;

    private final FluorographyMapper mapper;

    @Override
    public List<FluorographyEntity> findAll() {
        return fluorographyRepository.findAll();
    }

    @Override
    public List<FluorographyEntity> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return fluorographyRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public FluorographyEntity create(FluorographyCreateDto createDto) {
        FluorographyEntity fluorographyToSave = mapper.mapToEntity(createDto);

        Optional<StudentEntity> findedStudent = studentRepository.findById(createDto.getStudentId());

        if (findedStudent.isEmpty()){
            //TODO
            return null;
        }
        fluorographyToSave.setStudent(findedStudent.get());

        String imageURL = imageService.saveImage(createDto.getImage());
        fluorographyToSave.setImageURL(imageURL);

        return fluorographyRepository.save(fluorographyToSave);
    }

    @Override
    public FluorographyEntity update(FluorographyUpdateDto updateDto) {
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

        return fluorographyRepository.save(entityToUpdate);
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
