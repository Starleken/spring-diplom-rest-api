package com.example.DiplomRestApi.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public byte[] getImage(String imageName) throws Exception;

    public String saveImage(MultipartFile imageFile);

    public void deleteImage(String imageName);
}
