package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.ActivityEntity;
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
    public List<ActivityEntity> findAll(){
        return activityService.findAll();
    }

    @GetMapping(path = "/user")
    public List<ActivityEntity> findActivitiesByUser(@RequestParam Long userId){
        return activityService.findActivitiesByUser(userId);
    }

    @PostMapping
    public ActivityEntity save(@RequestBody ActivityEntity activityEntity){
        return activityService.save(activityEntity);
    }

    @PutMapping
    public ActivityEntity update(@RequestBody ActivityEntity activityEntity){
        return activityService.update(activityEntity);
    }
}
