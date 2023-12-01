package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.ActivityLevel;
import com.example.DiplomRestApi.service.ActivityLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/activityLevel")
public class ActivityLevelController {
    private ActivityLevelService activityLevelService;

    @Autowired
    public ActivityLevelController(ActivityLevelService activityLevelService) {
        this.activityLevelService = activityLevelService;
    }

    @GetMapping()
    public List<ActivityLevel> findAll(){
        return activityLevelService.findAll();
    }
}
