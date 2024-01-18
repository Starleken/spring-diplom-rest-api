package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.entity.EducationFormEntity;
import com.example.DiplomRestApi.service.EducationFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "educationForm")
@RequiredArgsConstructor
public class EducationFormController {

    private final EducationFormService service;

    @GetMapping
    public ResponseEntity<List<EducationFormFullDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
