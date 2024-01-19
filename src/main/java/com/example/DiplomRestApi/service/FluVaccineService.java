package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineFullDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface FluVaccineService {

    List<FluVaccineFullDto> findAll();

    List<FluVaccineFullDto> findAllByStudent(Long studentId);

    FluVaccineFullDto create(FluVaccineCreateDto createDto);

    FluVaccineFullDto update(FluVaccineUpdateDto updateDto);

    void delete(Long id);
}
