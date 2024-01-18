package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupFullDto>> findAll(){
        return new ResponseEntity<>(groupService.findAll(), HttpStatus.OK);
    }

    //TODO
    @PostMapping
    public GroupEntity save(@RequestBody GroupEntity groupEntity){
        return groupService.save(groupEntity);
    }
}
