package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import com.example.DiplomRestApi.service.ActivityLevelService;
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
@RequestMapping(path = "activityLevels")
@RequiredArgsConstructor
@Slf4j
public class ActivityLevelController {

    private final ActivityLevelService activityLevelService;

    @GetMapping
    public ResponseEntity<List<ActivityLevelFullDto>> findAll() {
        log.info("Find all activity levels requested");
        var entities = activityLevelService.findAll();
        log.info("The number of activity levels found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
