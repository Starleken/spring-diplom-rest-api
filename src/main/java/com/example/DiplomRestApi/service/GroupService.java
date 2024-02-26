package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;

import java.util.List;

public interface GroupService {
    List<GroupFullDto> findAll();

    GroupEntity save(GroupEntity groupEntity);
}
