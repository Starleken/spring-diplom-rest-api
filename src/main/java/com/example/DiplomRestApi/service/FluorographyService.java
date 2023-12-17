package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.FluorographyEntity;

import java.util.List;

public interface FluorographyService {

    List<FluorographyEntity> findAll();

    List<FluorographyEntity> findAllByStudent(Long studentId);

    FluorographyEntity create(FluorographyEntity entity);

    FluorographyEntity update(FluorographyEntity entity);

    void delete(Long id);
}
