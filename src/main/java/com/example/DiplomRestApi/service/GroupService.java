package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Group;
import com.example.DiplomRestApi.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }

    public Group save(Group group){
        return groupRepository.save(group);
    }
}
