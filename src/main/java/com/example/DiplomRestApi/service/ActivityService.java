package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {
    List<ActivityFullDto> findAll();

    ActivityFullDto save(ActivityCreateDto createDto);

    ActivityFullDto update(ActivityUpdateDto updateDto);

    List<ActivityFullDto> findActivitiesByStudent(long studentId);

    void deleteById(Long id);
}
