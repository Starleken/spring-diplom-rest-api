package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.Curator;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}