package com.example.DiplomRestApi.dto.passport;

import com.example.DiplomRestApi.entity.StudentEntity;
import lombok.Data;

@Data
public class PassportFullDto {

    private Long id;
    private String series;
    private String number;
    private StudentEntity student;
    private String imageURL;
}
