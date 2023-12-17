package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.SnilsRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.SnilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnilsServiceImpl implements SnilsService {

    private final SnilsRepository snilsRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<SnilsEntity> findAll() {
        return snilsRepository.findAll();
    }

    @Override
    public List<SnilsEntity> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return snilsRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public SnilsEntity create(SnilsEntity entity) {
        return snilsRepository.save(entity);
    }

    @Override
    public SnilsEntity update(SnilsEntity entity) {
        Optional<SnilsEntity> findedEntity = snilsRepository
                .findById(entity.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        SnilsEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(entity.getNumber());
        entityToUpdate.setImageURL(entity.getImageURL());

        return snilsRepository.save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        snilsRepository.deleteById(id);
    }
}
