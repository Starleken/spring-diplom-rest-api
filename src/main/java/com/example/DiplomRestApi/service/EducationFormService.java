package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.EducationForm;
import com.example.DiplomRestApi.repository.EducationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationFormService {
    private EducationFormRepository educationFormRepository;

    @Autowired
    public EducationFormService(EducationFormRepository educationFormRepository) {
        this.educationFormRepository = educationFormRepository;
    }

    public List<EducationForm> findAll(){
        return educationFormRepository.findAll();
    }
}
