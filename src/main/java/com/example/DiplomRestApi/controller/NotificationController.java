package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getByStudentId(@PathVariable Long id) {
        log.info("Find notifications by studentId: {} requested", id);
        var entities = notificationService.getByStudentId(id);
        log.info("The number of notification by student id: {} found: {}", id, entities.size());

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
