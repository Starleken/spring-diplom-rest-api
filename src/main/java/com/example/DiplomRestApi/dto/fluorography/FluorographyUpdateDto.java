package com.example.DiplomRestApi.dto.fluorography;

import com.example.DiplomRestApi.entity.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class FluorographyUpdateDto {

    private Long id;
    private String number;
    private Date createDate;
    private MultipartFile image;
}
