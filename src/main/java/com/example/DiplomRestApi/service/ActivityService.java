package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Activity;
import com.example.DiplomRestApi.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll(){
        return activityRepository.findAll();
    }
}
