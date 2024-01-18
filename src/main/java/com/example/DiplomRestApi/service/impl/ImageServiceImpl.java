package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private final String folderPath = "src/main/resouces/images/";

    @Override
    public byte[] getImage(String imageName) throws Exception{
        String absolutePath = new File("src/main/resources/static/images").getAbsolutePath();
        Path path = Paths.get(absolutePath + "/" + imageName);

        byte[] bytes = new UrlResource(path.toUri()).getContentAsByteArray();

        return bytes;
    }

    @Override
    public String saveImage(MultipartFile imageFile) {

        String uuid = UUID.randomUUID().toString();

        try{
            byte[] bytes = imageFile.getBytes();
            String absolutePath = new File("src/main/resources/static/images").getAbsolutePath();
            Path path = Paths.get(absolutePath + "/" +uuid + ".jpg");
            Path savedPath = Files.write(path, bytes);
        } catch (Exception ex) {
            return null;
        }

        return "http://127.0.0.1:8080/api/v1/image/" + uuid + ".jpg";
    }

    @Override
    public void deleteImage(String imageURL) {
        String absolutePath = new File("src/main/resources/static/images").getAbsolutePath();

        String[] splited = imageURL.split("/");
        Path path = Paths.get(absolutePath + "/" + splited[splited.length-1]);

        try{
            Files.delete(path);
        } catch (Exception ex){
            //TODO
        }

    }
}
