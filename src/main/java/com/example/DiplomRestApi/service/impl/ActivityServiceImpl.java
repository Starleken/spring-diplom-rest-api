package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.Activity;
import com.example.DiplomRestApi.repository.ActivityRepository;
import com.example.DiplomRestApi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> findAll(){
        return activityRepository.findAll();
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }
}
