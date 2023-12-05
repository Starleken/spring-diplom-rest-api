package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupEntity> findAll(){
        return groupService.findAll();
    }

    @PostMapping
    public GroupEntity save(@RequestBody GroupEntity groupEntity){
        return groupService.save(groupEntity);
    }
}
