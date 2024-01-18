package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "curator")
public class CuratorController {
    private CuratorService curatorService;

    @Autowired
    public CuratorController(CuratorService curatorService) {
        this.curatorService = curatorService;
    }

    @GetMapping
    public List<CuratorEntity> findAll(){
        return curatorService.findAll();
    }

    @GetMapping("/user")
    public CuratorEntity findCuratorByUser(@RequestParam Long userId){
        return curatorService.findCuratorByUser(userId);
    }

    @PostMapping
    public CuratorEntity create(@RequestBody CuratorEntity curatorEntity){
        return curatorService.create(curatorEntity);
    }

    @PutMapping
    public CuratorEntity update(@RequestBody CuratorEntity curatorEntity){
        return curatorService.update(curatorEntity);
    }
}
