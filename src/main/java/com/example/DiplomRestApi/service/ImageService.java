package com.example.DiplomRestApi.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public void saveImage(MultipartFile imageFile) throws Exception;
}
