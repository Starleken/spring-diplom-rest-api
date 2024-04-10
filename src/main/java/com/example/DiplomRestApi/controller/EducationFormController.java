package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.service.EducationFormService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "educationForms")
@RequiredArgsConstructor
@Slf4j
public class EducationFormController {

    private final EducationFormService educationFormService;

    @GetMapping
    public ResponseEntity<List<EducationFormFullDto>> findAll() {
        log.info("Find all education forms requested");
        var entities = educationFormService.findAll();
        log.info("The number of education forms found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
