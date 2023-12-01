package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private final String folderPath = "src/main/resouces/images/";

    @Override
    public void saveImage(MultipartFile imageFile) throws Exception{

        byte[] bytes = imageFile.getBytes();
        String absolutePath = new File("src/main/resources/static/images").getAbsolutePath();
        Path path = Paths.get(absolutePath + "/" +imageFile.getOriginalFilename());
        Path savedPath = Files.write(path, bytes);
        System.out.println(savedPath.toUri().getPath());
    }
}
