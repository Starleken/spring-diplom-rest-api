package com.example.DiplomRestApi.service.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.DiplomRestApi.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

//    private final String folderPath = "src/main/resouces/images/";

    private String accessKeyId = "YCAJEgPfPYYgZh-aeJmTJCpS2";
    private String secretAccessKey = "YCO6aMVzXHhwpkmwYJ_mRuAtZdhxRdxg8yMz8Mpe";
    private String bucketName = "cloud-image-storage";


    @Override
    public Resource getImage(String imageName) throws Exception{
        String absolutePath = new File("src/main/resources/static/images").getAbsolutePath();
        Path path = Paths.get(absolutePath + "/" + imageName);
        Resource resource = new UrlResource(path.toUri());
        return resource;
//        byte[] bytes = new UrlResource(path.toUri()).getContentAsByteArray();
//
//        return bytes;
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
            log.info(ex.getMessage());
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
