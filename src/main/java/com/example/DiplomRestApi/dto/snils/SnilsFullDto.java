package com.example.DiplomRestApi.dto.snils;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

@Data
public class SnilsFullDto {

    private Long id;
    private String number;
    private StudentFullDto student;
    private String imageURL;
}
