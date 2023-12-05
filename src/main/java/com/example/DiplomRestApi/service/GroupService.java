package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.GroupEntity;

import java.util.List;

public interface GroupService {
    public List<GroupEntity> findAll();

    public GroupEntity save(GroupEntity groupEntity);
}
