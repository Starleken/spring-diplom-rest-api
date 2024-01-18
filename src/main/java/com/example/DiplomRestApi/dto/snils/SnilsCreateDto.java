package com.example.DiplomRestApi.dto.snils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SnilsCreateDto {

    private String number;
    private long studentId;
    private MultipartFile image;
}
