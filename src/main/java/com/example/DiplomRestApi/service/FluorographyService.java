package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.entity.FluorographyEntity;

import java.util.List;

public interface FluorographyService {

    List<FluorographyEntity> findAll();

    List<FluorographyEntity> findAllByStudent(Long studentId);

    FluorographyEntity create(FluorographyCreateDto createDto);

    FluorographyEntity update(FluorographyUpdateDto updateDto);

    void delete(Long id);
}
