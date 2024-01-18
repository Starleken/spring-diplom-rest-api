package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {
    public List<ActivityEntity> findAll();

    public ActivityEntity save(ActivityCreateDto createDto);

    public ActivityEntity update(ActivityUpdateDto updateDto);

    public List<ActivityEntity> findActivitiesByStudent(long studentId);

    public void deleteById(Long id);
}
