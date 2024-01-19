package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsFullDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;

import java.util.List;

public interface SnilsService {

    List<SnilsFullDto> findAll();

    List<SnilsFullDto> findAllByStudent(Long studentId);

    SnilsFullDto create(SnilsCreateDto createDto);

    SnilsFullDto update(SnilsUpdateDto updateDto);

    void delete(Long id);
}
