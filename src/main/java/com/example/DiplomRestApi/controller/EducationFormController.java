package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.EducationFormEntity;
import com.example.DiplomRestApi.service.EducationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/educationForm")
public class EducationFormController {
    private EducationFormService service;

    @Autowired
    public EducationFormController(EducationFormService service) {
        this.service = service;
    }

    @GetMapping
    public List<EducationFormEntity> findAll(){
        return service.findAll();
    }
}
