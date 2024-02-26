package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;

import java.util.List;

public interface PassportService{
    List<PassportFullDto> findAll();
    List<PassportFullDto> findAllByStudent(Long studentId);

    PassportFullDto create(PassportCreateDto passportToSaveDto);

    PassportFullDto update(PassportUpdateDto passportToUpdateDto);

    void deleteById(Long id);
}
