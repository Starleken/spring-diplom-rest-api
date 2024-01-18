package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;
import com.example.DiplomRestApi.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "passport")
public class PassportController {
    private PassportService passportService;

    @Autowired
    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping()
    public List<PassportFullDto> findAll(){
        return passportService.findAll();
    }

    @GetMapping(path = "/student")
    public List<PassportFullDto> findAllByStudent(@RequestParam Long studentId){
        return passportService.findAllByStudent(studentId);
    }

    @PostMapping()
    public PassportFullDto create(@ModelAttribute PassportCreateDto passportCreateDTO){
        return passportService.create(passportCreateDTO);
    }

    @PutMapping()
    public PassportFullDto update(@ModelAttribute PassportUpdateDto updateDTO){
        return passportService.update(updateDTO);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        passportService.deleteById(id);
    }
}
