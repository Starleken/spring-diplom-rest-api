package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import com.example.DiplomRestApi.repository.ActivityTypeRepository;
import com.example.DiplomRestApi.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    public ActivityTypeServiceImpl(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public List<ActivityTypeEntity> findAll(){
        return activityTypeRepository.findAll();
    }
}
