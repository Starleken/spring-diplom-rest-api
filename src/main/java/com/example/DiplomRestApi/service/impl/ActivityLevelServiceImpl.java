package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import com.example.DiplomRestApi.mapper.ActivityLevelMapper;
import com.example.DiplomRestApi.repository.ActivityLevelRepository;
import com.example.DiplomRestApi.service.ActivityLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityLevelServiceImpl implements ActivityLevelService {

    private final ActivityLevelRepository activityLevelRepository;

    private final ActivityLevelMapper mapper;

    @Override
    public List<ActivityLevelFullDto> findAll() {
        List<ActivityLevelEntity> entities = activityLevelRepository.findAll();

        List<ActivityLevelFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }
}
