package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineCreateDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineFullDto;
import com.example.DiplomRestApi.dto.fluVaccine.FluVaccineUpdateDto;
import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.service.FluVaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fluVaccine")
@RequiredArgsConstructor
public class FluVaccineController {

    private final FluVaccineService fluVaccineService;

    @GetMapping()
    public ResponseEntity<List<FluVaccineFullDto>> findAll(){
        return new ResponseEntity<>(fluVaccineService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<FluVaccineFullDto>> findAllByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(fluVaccineService.findAllByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<FluVaccineFullDto> create(@ModelAttribute FluVaccineCreateDto createDto){
        return new ResponseEntity<>(fluVaccineService.create(createDto), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<FluVaccineFullDto> update(@ModelAttribute  FluVaccineUpdateDto updateDto){
        return new ResponseEntity<>(fluVaccineService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        fluVaccineService.delete(id);
    }
}
