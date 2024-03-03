package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyFullDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.service.FluorographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fluorography")
@RequiredArgsConstructor
public class FluorographyController {

    private final FluorographyService fluorographyService;

    @GetMapping()
    public List<FluorographyFullDto> findAll(){
        return fluorographyService.findAll();
    }

    @GetMapping(path = "/student")
    public ResponseEntity<FluorographyFullDto> findByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(fluorographyService.findByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<FluorographyFullDto> create(@ModelAttribute FluorographyCreateDto createDto){
        return new ResponseEntity<>(fluorographyService.create(createDto), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<FluorographyFullDto> update(@ModelAttribute FluorographyUpdateDto updateDto){
        return new ResponseEntity<>(fluorographyService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        fluorographyService.delete(id);
    }
}
