package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.entity.ActivityLevelEntity;

import java.util.List;

public interface ActivityLevelService {

    List<ActivityLevelFullDto> findAll();
}
