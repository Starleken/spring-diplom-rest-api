package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.group.GroupCreateDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.mapper.GroupMapper;
import com.example.DiplomRestApi.repository.GroupRepository;
import com.example.DiplomRestApi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper mapper;

    public List<GroupFullDto> findAll(){
        List<GroupEntity> entities = groupRepository.findAll();

        List<GroupFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public GroupFullDto save(GroupCreateDto createDto) {
        var group = mapper.mapToEntity(createDto);
        var saved = groupRepository.save(group);

        return mapper.mapToDto(saved);
    }
}
