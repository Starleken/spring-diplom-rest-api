package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.activityType.ActivityTypeFullDto;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;

import java.util.List;

public interface ActivityTypeService {
    public List<ActivityTypeFullDto> findAll();
}
