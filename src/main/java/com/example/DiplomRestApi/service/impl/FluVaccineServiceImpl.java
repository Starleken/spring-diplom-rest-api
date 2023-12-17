package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.FluVaccineRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.FluVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FluVaccineServiceImpl implements FluVaccineService {

    private final FluVaccineRepository fluVaccineRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<FluVaccineEntity> findAll() {
        return fluVaccineRepository.findAll();
    }

    @Override
    public List<FluVaccineEntity> findAllByStudent(Long studentId) {
        Optional<StudentEntity> findedStudent = studentRepository.findById(studentId);

        //TODO
        if (findedStudent.isEmpty()){
            return null;
        }

        return fluVaccineRepository.findAllByStudent(findedStudent.get());
    }

    @Override
    public FluVaccineEntity create(FluVaccineEntity entity) {
        return fluVaccineRepository.save(entity);
    }

    @Override
    public FluVaccineEntity update(FluVaccineEntity entity) {
        Optional<FluVaccineEntity> findedEntity = fluVaccineRepository.
                findById(entity.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        FluVaccineEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setCreateDate(entity.getCreateDate());
        entityToUpdate.setImageURL(entity.getImageURL());

        return fluVaccineRepository.save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        //TODO
        fluVaccineRepository.deleteById(id);
    }
}
