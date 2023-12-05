package com.example.DiplomRestApi.dto.passport;

import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import lombok.Data;

@Data
public class PassportFullDTO {
    private Long id;
    private String series;
    private String number;
    private StudentEntity student;
    private String imageURL;
}
