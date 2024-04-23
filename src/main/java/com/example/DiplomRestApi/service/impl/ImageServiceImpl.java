package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Override
    public Resource getImage(String imageName) throws Exception{
        String absolutePath = new File("images").getAbsolutePath();
        Path path = Paths.get(absolutePath + "/" + imageName);
        Resource resource = new UrlResource(path.toUri());
        return resource;
    }

    @Override
    public String saveImage(MultipartFile imageFile) {

        String uuid = UUID.randomUUID().toString();

        try{
            byte[] bytes = imageFile.getBytes();
            String absolutePath = new File("images").getAbsolutePath();
            Path path = Paths.get(absolutePath + "/" +uuid + ".jpg");
            Path savedPath = Files.write(path, bytes);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return null;
        }

        return "http://89.23.115.9/api/v1/image/" + uuid + ".jpg";
    }

    @Override
    public void deleteImage(String imageURL) {
        String absolutePath = new File("images").getAbsolutePath();

        String[] splited = imageURL.split("/");
        Path path = Paths.get(absolutePath + "/" + splited[splited.length-1]);

        try{
            Files.delete(path);
        } catch (Exception ex){
            //TODO
        }

    }
}
