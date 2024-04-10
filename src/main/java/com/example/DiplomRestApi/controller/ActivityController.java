package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "activities")
@RequiredArgsConstructor
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ActivityFullDto>> findAll() {
        log.info("Find all activities requested");
        var entities = activityService.findAll();
        log.info("The number of activities found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<ActivityFullDto>> findAllByStudent(@RequestParam Long studentId) {
        log.info("Find activities by student requested. StudentId: {}", studentId);
        var entities = activityService.findActivitiesByStudent(studentId);
        log.info("The number of activities by studentId {} found: {}", studentId, entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityFullDto> create(@ModelAttribute ActivityCreateDto createDto) {
        log.info("Activity create request: {}", createDto);
        var created = activityService.save(createDto);
        log.info("Created activity: {}", created);

        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ActivityFullDto> update(@ModelAttribute ActivityUpdateDto updateDto) {
        log.info("Activity update request: {}", updateDto);
        var updated = activityService.update(updateDto);
        log.info("Updated activity: {}", updated);

        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Activity delete request. Id: {}", id);
        activityService.deleteById(id);
        log.info("Activity deleted. Id: {}", id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
