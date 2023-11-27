package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.EducationForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "api/v1/educationform")
public class EducationFormController {

    @GetMapping
    public List<EducationForm> findAll(){
        return null;
    }
}
