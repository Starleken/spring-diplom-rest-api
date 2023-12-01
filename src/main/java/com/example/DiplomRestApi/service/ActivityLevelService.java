package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.ActivityLevel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActivityLevelService {

    public List<ActivityLevel> findAll();
}
