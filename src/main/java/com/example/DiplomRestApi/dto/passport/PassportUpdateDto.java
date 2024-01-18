package com.example.DiplomRestApi.dto.passport;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PassportUpdateDto {
    private Long id;
    private String series;
    private String number;
    private MultipartFile image;
}
