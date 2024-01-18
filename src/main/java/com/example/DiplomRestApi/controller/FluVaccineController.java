package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.service.FluVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fluVaccine")
@RequiredArgsConstructor
public class FluVaccineController {

    private final FluVaccineService fluVaccineService;

    @GetMapping()
    public List<FluVaccineEntity> findAll(){
        return fluVaccineService.findAll();
    }

    @GetMapping(path = "/student")
    public List<FluVaccineEntity> findAllByStudent(@RequestParam Long studentId){
        return fluVaccineService.findAllByStudent(studentId);
    }

    @PostMapping()
    public FluVaccineEntity create(@ModelAttribute FluVaccineCreateDto createDto){
        return fluVaccineService.create(createDto);
    }

    @PutMapping()
    public FluVaccineEntity update(@ModelAttribute  FluVaccineUpdateDto updateDto){
        return fluVaccineService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        fluVaccineService.delete(id);
    }
}
