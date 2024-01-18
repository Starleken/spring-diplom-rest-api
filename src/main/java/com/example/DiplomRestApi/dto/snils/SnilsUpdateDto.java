package com.example.DiplomRestApi.dto.snils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SnilsUpdateDto {

    private long id;
    private String number;
    private MultipartFile image;
}
