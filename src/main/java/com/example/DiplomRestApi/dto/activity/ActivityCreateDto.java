package com.example.DiplomRestApi.dto.activity;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@Data
@Builder
public class ActivityCreateDto {

    private String name;
    private Date date;
    private Integer place;
    private String eventPlace;
    private MultipartFile image;
    private Long activityTypeId;
    private Long activityLevelId;
    private Long studentId;
}
