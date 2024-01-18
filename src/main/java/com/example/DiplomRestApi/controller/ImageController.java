package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.service.ImageService;
import lombok.RequiredArgsConstructor;
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
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> loadImage(@PathVariable String imageName){
        try{
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageService.getImage(imageName));
        } catch (Exception ex){
            return null;
        }
    }

    @PostMapping()
    public String saveImage(@RequestBody MultipartFile multipartFile){
        try{
            return imageService.saveImage(multipartFile);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
