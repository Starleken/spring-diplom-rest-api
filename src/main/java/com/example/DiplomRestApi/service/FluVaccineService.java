package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface FluVaccineService {

    List<FluVaccineEntity> findAll();

    List<FluVaccineEntity> findAllByStudent(Long studentId);

    FluVaccineEntity create(FluVaccineEntity entity);

    FluVaccineEntity update(FluVaccineEntity entity);

    void delete(Long id);
}
