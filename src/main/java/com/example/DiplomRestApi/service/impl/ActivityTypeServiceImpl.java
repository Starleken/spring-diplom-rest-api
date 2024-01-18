package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.activityType.ActivityTypeFullDto;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import com.example.DiplomRestApi.mapper.ActivityTypeMapper;
import com.example.DiplomRestApi.repository.ActivityTypeRepository;
import com.example.DiplomRestApi.service.ActivityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    private final ActivityTypeMapper mapper;

    @Override
    public List<ActivityTypeFullDto> findAll(){
        List<ActivityTypeEntity> entities = activityTypeRepository.findAll();

        List<ActivityTypeFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }
}
