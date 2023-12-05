package com.example.DiplomRestApi.dto.passport;

import com.example.DiplomRestApi.entity.StudentEntity;
import lombok.Data;

@Data
public class PassportCreateDTO {
    private String series;
    private String number;
    private Long studentId;
    private String imageURL;
}
