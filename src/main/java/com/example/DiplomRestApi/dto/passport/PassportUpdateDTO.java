package com.example.DiplomRestApi.dto.passport;

import com.example.DiplomRestApi.entity.StudentEntity;
import lombok.Data;

@Data
public class PassportUpdateDTO {
    private Long id;
    private String series;
    private String number;
    private String imageURL;
}
