package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {
    public List<ActivityFullDto> findAll();

    public ActivityFullDto save(ActivityCreateDto createDto);

    public ActivityFullDto update(ActivityUpdateDto updateDto);

    public List<ActivityFullDto> findActivitiesByStudent(long studentId);

    public void deleteById(Long id);
}
