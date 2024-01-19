package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.inn.InnCreateDto;
import com.example.DiplomRestApi.dto.inn.InnFullDto;
import com.example.DiplomRestApi.dto.inn.InnUpdateDto;
import com.example.DiplomRestApi.entity.InnEntity;

import java.util.List;

public interface InnService {

    List<InnFullDto> findAll();

    List<InnFullDto> findAllByStudent(Long studentId);

    InnFullDto create(InnCreateDto createDto);

    InnFullDto update(InnUpdateDto updateDto);

    void deleteById(Long id);
}
