package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.entity.EducationFormEntity;

import java.util.List;

public interface EducationFormService {
    public List<EducationFormFullDto> findAll();
}
