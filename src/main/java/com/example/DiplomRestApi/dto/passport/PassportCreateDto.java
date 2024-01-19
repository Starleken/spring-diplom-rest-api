package com.example.DiplomRestApi.dto.passport;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PassportCreateDto {
    private String series;
    private String number;
    private Long studentId;
    private MultipartFile image;
}