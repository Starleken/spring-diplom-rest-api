package com.example.DiplomRestApi.dto.medicalPolicy;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

@Data
public class MedicalPolicyFullDto {

    private Long id;
    private String number;
    private String imageURL;
    private StudentFullDto student;
}
