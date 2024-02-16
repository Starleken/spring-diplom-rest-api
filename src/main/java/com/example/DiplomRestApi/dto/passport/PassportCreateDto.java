package com.example.DiplomRestApi.dto.passport;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class PassportCreateDto {

    private String series;
    private String number;
    private Date issueDate;
    private Long studentId;
    private MultipartFile image;
}
