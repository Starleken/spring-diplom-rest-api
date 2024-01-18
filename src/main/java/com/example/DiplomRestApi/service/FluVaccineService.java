package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;

import java.util.List;

public interface FluVaccineService {

    List<FluVaccineEntity> findAll();

    List<FluVaccineEntity> findAllByStudent(Long studentId);

    FluVaccineEntity create(FluVaccineCreateDto createDto);

    FluVaccineEntity update(FluVaccineUpdateDto updateDto);

    void delete(Long id);
}
