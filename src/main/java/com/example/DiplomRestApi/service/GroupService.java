package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.group.GroupCreateDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;

import java.util.List;

public interface GroupService {
    List<GroupFullDto> findAll();

    GroupFullDto save(GroupCreateDto createDto);
}
