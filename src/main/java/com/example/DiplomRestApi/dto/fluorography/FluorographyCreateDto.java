package com.example.DiplomRestApi.dto.fluorography;

import com.example.DiplomRestApi.entity.StudentEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class FluorographyCreateDto {

    private String number;
    private Date createDate;
    private Long studentId;
    private MultipartFile image;
}
