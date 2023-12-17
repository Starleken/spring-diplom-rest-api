package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.FluorographyEntity;
import com.example.DiplomRestApi.service.FluorographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fluorography")
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
    public FluorographyEntity create(FluorographyEntity entity){
        return fluorographyService.create(entity);
    }
}
