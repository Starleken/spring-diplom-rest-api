package com.example.DiplomRestApi.dto.activity;

import com.example.DiplomRestApi.dto.activityLevel.ActivityLevelFullDto;
import com.example.DiplomRestApi.dto.activityType.ActivityTypeFullDto;
import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

import java.sql.Date;

@Data
public class ActivityFullDto {

    private Long id;
    private String name;
    private Date date;
    private Integer place;
    private String eventPlace;
    private String imageUrl;
    private ActivityTypeFullDto activityType;
    private ActivityLevelFullDto activityLevel;
    private StudentFullDto student;
}
