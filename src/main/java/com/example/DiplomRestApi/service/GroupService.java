package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Group;

import java.util.List;

public interface GroupService {
    public List<Group> findAll();

    public Group save(Group group);
}
