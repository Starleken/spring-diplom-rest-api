package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Activity;

import java.util.List;

public interface ActivityService {
    public List<Activity> findAll();

    public Activity save(Activity activity);

    public Activity update(Activity activity);
}
