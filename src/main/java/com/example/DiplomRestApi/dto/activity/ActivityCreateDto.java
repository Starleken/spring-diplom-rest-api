package com.example.DiplomRestApi.dto.activity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;


@Data
public class ActivityCreateDto {

    private String name;
    private Date date;
    private Integer place;
    private MultipartFile image;
    private Long activityTypeId;
    private Long activityLevelId;
    private Long studentId;
}
