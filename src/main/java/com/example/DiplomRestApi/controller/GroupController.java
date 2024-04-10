package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.group.GroupCreateDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
@Slf4j
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupFullDto>> findAll() {
        log.info("Find all groups requested");
        var entities = groupService.findAll();
        log.info("The number of groups found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<GroupFullDto> create(@RequestBody GroupCreateDto createDto) {
        log.info("Create group request: {}", createDto);
        var entity = groupService.save(createDto);
        log.info("Created group: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }
}
