package com.example.DiplomRestApi.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Resource getImage(String imageName) throws Exception;

    String saveImage(MultipartFile imageFile);

    void deleteImage(String imageName);
}
