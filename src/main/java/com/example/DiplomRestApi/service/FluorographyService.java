package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.entity.FluorographyEntity;

import java.util.List;

public interface FluorographyService {

    List<FluorographyFullDto> findAll();

    FluorographyFullDto findByStudent(Long studentId);

    FluorographyFullDto create(FluorographyCreateDto createDto);

    FluorographyFullDto update(FluorographyUpdateDto updateDto);

    void delete(Long id);
}
