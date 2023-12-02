package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.Activity;
import com.example.DiplomRestApi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/activity")
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> findAll(){
        return activityService.findAll();
    }

    @PostMapping
    public Activity save(@RequestBody Activity activity){
        return activityService.save(activity);
    }

    @PutMapping
    public Activity update(@RequestBody Activity activity){
        return activityService.update(activity);
    }
}
