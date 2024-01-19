package com.example.DiplomRestApi.dto.inn;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

@Data
public class InnFullDto {

    private Long id;
    private String number;
    private StudentFullDto student;
    private String imageURL;
}
