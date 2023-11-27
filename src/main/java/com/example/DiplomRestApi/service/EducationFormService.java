package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.repository.EducationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationFormService {
    private EducationFormRepository educationFormRepository;

    @Autowired
    public EducationFormService(EducationFormRepository educationFormRepository) {
        this.educationFormRepository = educationFormRepository;
    }
}
