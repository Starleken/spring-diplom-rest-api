package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.service.CuratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "curator")
@RequiredArgsConstructor
public class CuratorController {

    private final CuratorService curatorService;

    @GetMapping
    public ResponseEntity<List<CuratorFullDto>> findAll(){
        return new ResponseEntity<>(curatorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<CuratorFullDto> findCuratorByUser(@RequestParam Long userId){
        return new ResponseEntity<>(curatorService.findCuratorByUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CuratorFullDto> create(@RequestBody CuratorEntity curatorEntity){
        return new ResponseEntity<>(curatorService.create(curatorEntity), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CuratorFullDto> update(@RequestBody CuratorEntity curatorEntity){
        return new ResponseEntity<>(curatorService.update(curatorEntity), HttpStatus.OK);
    }
}
