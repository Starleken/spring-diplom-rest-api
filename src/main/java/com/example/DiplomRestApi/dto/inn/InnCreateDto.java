package com.example.DiplomRestApi.dto.inn;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InnCreateDto {

    private String number;
    private long studentId;
    private MultipartFile image;
}
