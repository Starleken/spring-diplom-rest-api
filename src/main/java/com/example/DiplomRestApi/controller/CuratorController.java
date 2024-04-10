package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.dto.curator.CuratorUpdateDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.service.CuratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "curators")
@RequiredArgsConstructor
@Slf4j
public class CuratorController {

    private final CuratorService curatorService;

    @GetMapping
    public ResponseEntity<List<CuratorFullDto>> findAll() {
        log.info("Find all curators requested");
        var entities = curatorService.findAll();
        log.info("The number of curators found: {}", entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<CuratorFullDto> findCuratorByUser(@RequestParam Long userId) {
        log.info("Find curator by user requested. UserId: {}", userId);
        var entity = curatorService.findCuratorByUser(userId);
        log.info("Found curator by userId: {}", entity);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CuratorFullDto> create(@RequestBody CuratorCreateDto createDto) {
        log.info("Curator create request: {}", createDto);
        var created = curatorService.create(createDto);
        log.info("Created curator: {}", created);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CuratorFullDto> update(@RequestBody CuratorUpdateDto updateDto) {
        log.info("Update curator request: {}", updateDto);
        var updated = curatorService.update(updateDto);
        log.info("Updated curator: {}", updated);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
