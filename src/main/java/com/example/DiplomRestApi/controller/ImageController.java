package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api/v1/image")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping()
    public void saveImage(@RequestBody MultipartFile multipartFile){
        try{
            imageService.saveImage(multipartFile);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
