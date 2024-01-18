package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnUpdateDto;
import com.example.DiplomRestApi.entity.InnEntity;

import java.util.List;

public interface InnService {

    List<InnEntity> findAll();

    List<InnEntity> findAllByStudent(Long studentId);

    InnEntity create(InnCreateDto createDto);

    InnEntity update(InnUpdateDto updateDto);

    void deleteById(Long id);
}
