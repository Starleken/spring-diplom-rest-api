package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.FluorographyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.FluorographyRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.FluorographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FluorographyServiceImpl implements FluorographyService {

    private final FluorographyRepository fluorographyRepository;
    private final StudentRepository studentRepository;

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
    public FluorographyEntity create(FluorographyEntity entity) {
        return fluorographyRepository.save(entity);
    }

    @Override
    public FluorographyEntity update(FluorographyEntity entity) {
        Optional<FluorographyEntity> findedEntity = fluorographyRepository
                .findById(entity.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        FluorographyEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(entity.getNumber());
        entityToUpdate.setCreateDate(entity.getCreateDate());
        entityToUpdate.setImageURL(entity.getImageURL());

        return fluorographyRepository.save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        //TODO
        fluorographyRepository.deleteById(id);
    }
}
