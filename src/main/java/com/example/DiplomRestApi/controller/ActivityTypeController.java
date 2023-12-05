package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import com.example.DiplomRestApi.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/activityType")
public class ActivityTypeController {

    private ActivityTypeService activityTypeService;

    @Autowired
    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    @GetMapping
    public List<ActivityTypeEntity> findAll(){
        return activityTypeService.findAll();
    }
}
