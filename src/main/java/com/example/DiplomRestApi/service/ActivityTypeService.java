package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.ActivityType;
import com.example.DiplomRestApi.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {

    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    public ActivityTypeService(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    public List<ActivityType> findAll(){
        return activityTypeRepository.findAll();
    }
}
