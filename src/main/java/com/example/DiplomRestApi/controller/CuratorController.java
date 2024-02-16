package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.dto.curator.CuratorUpdateDto;
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
    public ResponseEntity<CuratorFullDto> create(@RequestBody CuratorCreateDto createDto){
        return new ResponseEntity<>(curatorService.create(createDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CuratorFullDto> update(@RequestBody CuratorUpdateDto updateDto){
        return new ResponseEntity<>(curatorService.update(updateDto), HttpStatus.OK);
    }
}
