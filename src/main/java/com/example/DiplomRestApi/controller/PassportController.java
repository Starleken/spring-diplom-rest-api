package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.dto.passport.PassportUpdateDto;
import com.example.DiplomRestApi.service.PassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "passport")
@RequiredArgsConstructor
@Slf4j
public class PassportController {
    private final PassportService passportService;

    @GetMapping()
    public ResponseEntity<List<PassportFullDto>> findAll(){
        return new ResponseEntity<>(passportService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<PassportFullDto> findByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(passportService.findByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PassportFullDto> create(@ModelAttribute PassportCreateDto passportCreateDTO){
        return new ResponseEntity<>(passportService.create(passportCreateDTO), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PassportFullDto> update(@ModelAttribute PassportUpdateDto updateDTO){
        return new ResponseEntity<>(passportService.update(updateDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id){
        passportService.deleteById(id);
    }
}
