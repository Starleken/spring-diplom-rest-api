package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activityType.ActivityTypeFullDto;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import com.example.DiplomRestApi.service.ActivityTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "activityTypes")
@RequiredArgsConstructor
@Slf4j
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    @GetMapping
    public ResponseEntity<List<ActivityTypeFullDto>> findAll() {
        log.info("Find all activity types requested");
        var entities = activityTypeService.findAll();
        log.info("The number of activity types found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
