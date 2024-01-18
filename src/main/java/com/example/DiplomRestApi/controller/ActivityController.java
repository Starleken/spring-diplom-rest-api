package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;
import com.example.DiplomRestApi.dto.activity.ActivityUpdateDto;
import com.example.DiplomRestApi.entity.ActivityEntity;
import com.example.DiplomRestApi.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ActivityEntity>> findAll(){
        return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/student")
    public ResponseEntity<List<ActivityEntity>> findActivitiesByStudent(@RequestParam Long studentId){
        return new ResponseEntity<>(activityService.findActivitiesByStudent(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityEntity> save(@ModelAttribute ActivityCreateDto createDto){
        return new ResponseEntity<>(activityService.save(createDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ActivityEntity> update(@ModelAttribute ActivityUpdateDto updateDto){
        return new ResponseEntity<>(activityService.update(updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        activityService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
