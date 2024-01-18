package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import com.example.DiplomRestApi.service.ActivityLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "activityLevel")
@RequiredArgsConstructor
public class ActivityLevelController {

    private final ActivityLevelService activityLevelService;

    @GetMapping()
    public ResponseEntity<List<ActivityLevelFullDto>> findAll(){
        return new ResponseEntity<>(activityLevelService.findAll(), HttpStatus.OK);
    }
}
