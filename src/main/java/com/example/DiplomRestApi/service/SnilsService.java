package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.snils.SnilsCreateDto;
import com.example.DiplomRestApi.dto.snils.SnilsUpdateDto;
import com.example.DiplomRestApi.entity.SnilsEntity;

import java.util.List;

public interface SnilsService {

    List<SnilsEntity> findAll();

    List<SnilsEntity> findAllByStudent(Long studentId);

    SnilsEntity create(SnilsCreateDto createDto);

    SnilsEntity update(SnilsUpdateDto updateDto);

    void delete(Long id);
}
