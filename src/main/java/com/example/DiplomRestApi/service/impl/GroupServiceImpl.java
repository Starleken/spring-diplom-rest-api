package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.repository.GroupRepository;
import com.example.DiplomRestApi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupEntity> findAll(){
        return groupRepository.findAll();
    }

    public GroupEntity save(GroupEntity groupEntity){
        return groupRepository.save(groupEntity);
    }
}
