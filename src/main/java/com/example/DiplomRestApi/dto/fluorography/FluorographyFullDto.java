package com.example.DiplomRestApi.dto.fluorography;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

import java.sql.Date;

@Data
public class FluorographyFullDto {

    private Long id;
    private String number;
    private Date createDate;
    private StudentFullDto student;
    private String imageURL;
}
