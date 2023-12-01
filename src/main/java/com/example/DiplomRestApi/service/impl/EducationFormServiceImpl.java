package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.EducationForm;
import com.example.DiplomRestApi.repository.EducationFormRepository;
import com.example.DiplomRestApi.service.EducationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationFormServiceImpl implements EducationFormService {
    private EducationFormRepository educationFormRepository;

    @Autowired
    public EducationFormServiceImpl(EducationFormRepository educationFormRepository) {
        this.educationFormRepository = educationFormRepository;
    }

    @Override
    public List<EducationForm> findAll(){
        return educationFormRepository.findAll();
    }
}
