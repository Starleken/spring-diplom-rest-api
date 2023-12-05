package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDTO;
import com.example.DiplomRestApi.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/passport")
public class PassportController {
    private PassportService passportService;

    @Autowired
    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping()
    public List<PassportFullDTO> findAll(){
        return passportService.findAll();
    }

    @GetMapping(path = "/student")
    public List<PassportFullDTO> findAllByStudent(@RequestParam Long studentId){
        return passportService.findAllByStudent(studentId);
    }

    @PostMapping()
    public PassportFullDTO create(@RequestBody PassportCreateDTO passportCreateDTO){
        return passportService.create(passportCreateDTO);
    }

    @PutMapping()
    public PassportFullDTO update(@RequestBody PassportUpdateDTO updateDTO){
        return passportService.update(updateDTO);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        passportService.deleteById(id);
    }
}
