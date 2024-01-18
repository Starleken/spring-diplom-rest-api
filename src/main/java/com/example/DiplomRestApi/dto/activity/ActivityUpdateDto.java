package com.example.DiplomRestApi.dto.activity;

import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class ActivityUpdateDto {

    private Long id;
    private String name;
    private Date date;
    private Integer place;
    private MultipartFile image;
    private Long activityTypeId;
    private Long activityLevelId;
}
