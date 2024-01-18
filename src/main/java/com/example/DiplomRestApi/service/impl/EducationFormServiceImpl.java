package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.entity.EducationFormEntity;
import com.example.DiplomRestApi.mapper.EducationFormMapper;
import com.example.DiplomRestApi.repository.EducationFormRepository;
import com.example.DiplomRestApi.service.EducationFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationFormServiceImpl implements EducationFormService {
    private final EducationFormRepository educationFormRepository;

    private final EducationFormMapper mapper;

    @Override
    public List<EducationFormFullDto> findAll(){
        List<EducationFormEntity> entities = educationFormRepository.findAll();

        List<EducationFormFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }
}
