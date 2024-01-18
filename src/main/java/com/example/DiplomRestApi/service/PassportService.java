package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;

import java.util.List;

public interface PassportService{
    public List<PassportFullDto> findAll();
    public List<PassportFullDto> findAllByStudent(Long studentId);

    public PassportFullDto create(PassportCreateDto passportToSaveDto);

    public PassportFullDto update(PassportUpdateDto passportToUpdateDto);

    public void deleteById(Long id);
}
