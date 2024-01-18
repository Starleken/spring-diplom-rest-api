package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.fluorography.FluorographyCreateDto;
import com.example.DiplomRestApi.dto.fluorography.FluorographyUpdateDto;
import com.example.DiplomRestApi.entity.FluorographyEntity;
import com.example.DiplomRestApi.service.FluorographyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "fluorography")
@RequiredArgsConstructor
public class FluorographyController {

    private final FluorographyService fluorographyService;

    @GetMapping()
    public List<FluorographyEntity> findAll(){
        return fluorographyService.findAll();
    }

    @GetMapping(path = "/student")
    public List<FluorographyEntity> findAllByStudent(@RequestParam Long studentId){
        return fluorographyService.findAllByStudent(studentId);
    }

    @PostMapping()
    public FluorographyEntity create(@ModelAttribute FluorographyCreateDto createDto){
        return fluorographyService.create(createDto);
    }
    
    @PutMapping
    public FluorographyEntity update(@ModelAttribute FluorographyUpdateDto updateDto){
        log.info(updateDto.toString());
        return fluorographyService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        fluorographyService.delete(id);
    }
}
