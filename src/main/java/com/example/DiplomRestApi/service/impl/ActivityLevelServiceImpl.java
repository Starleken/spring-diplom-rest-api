package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import com.example.DiplomRestApi.repository.ActivityLevelRepository;
import com.example.DiplomRestApi.service.ActivityLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLevelServiceImpl implements ActivityLevelService {

    private ActivityLevelRepository activityLevelRepository;

    @Autowired
    public ActivityLevelServiceImpl(ActivityLevelRepository activityLevelRepository) {
        this.activityLevelRepository = activityLevelRepository;
    }

    @Override
    public List<ActivityLevelEntity> findAll() {
        return activityLevelRepository.findAll();
    }
}
