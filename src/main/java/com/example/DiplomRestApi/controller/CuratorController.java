package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.Curator;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/curator")
public class CuratorController {
    private CuratorService curatorService;

    @Autowired
    public CuratorController(CuratorService curatorService) {
        this.curatorService = curatorService;
    }

    @GetMapping
    public List<Curator> findAll(){
        return curatorService.findAll();
    }

    @PostMapping
    public Curator create(@RequestBody Curator curator){
        return curatorService.create(curator);
    }

    @PutMapping
    public Curator update(@RequestBody Curator curator){
        return curatorService.update(curator);
    }
}
