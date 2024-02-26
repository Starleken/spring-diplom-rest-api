package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "image")
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> loadImage(@PathVariable String imageName){
        log.info(imageName);
        try{
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageService.getImage(imageName));
        } catch (Exception ex){
            return null;
        }
    }
}
