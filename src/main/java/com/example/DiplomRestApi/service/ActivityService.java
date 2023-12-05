package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {
    public List<ActivityEntity> findAll();

    public ActivityEntity save(ActivityEntity activityEntity);

    public ActivityEntity update(ActivityEntity activityEntity);

    public List<ActivityEntity> findActivitiesByUser(long userId);
}
