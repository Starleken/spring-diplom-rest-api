package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.service.InnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/inn")
@RequiredArgsConstructor
public class InnController {

    private final InnService innService;

    @GetMapping()
    private List<InnEntity> findAll(){
        return innService.findAll();
    }

    @PostMapping
    private InnEntity create(InnEntity entity){
        return innService.create(entity);
    }
}
