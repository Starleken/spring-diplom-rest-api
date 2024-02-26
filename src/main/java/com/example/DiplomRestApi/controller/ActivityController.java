package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;
import com.example.DiplomRestApi.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "activity")
@RequiredArgsConstructor
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ActivityFullDto>> findAll(){
        return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<ActivityFullDto>> findActivitiesByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(activityService.findActivitiesByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityFullDto> save(@ModelAttribute ActivityCreateDto createDto){
        log.info("User create request: {}", createDto);
        var createdActivity = activityService.save(createDto);
        log.info("Created activity: {}", createdActivity);

        return new ResponseEntity<>(createdActivity, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ActivityFullDto> update(@ModelAttribute ActivityUpdateDto updateDto){
        log.info("User update request: {}", updateDto);
        var updated = activityService.update(updateDto);
        log.info("Updated activity: {}", updated);

        return new ResponseEntity<>(updated, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        activityService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
