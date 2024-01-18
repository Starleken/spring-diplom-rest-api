package com.example.DiplomRestApi.dto.medicalPolicy;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MedicalPolicyCreateDto {

    private String number;
    private MultipartFile image;
    private Long studentId;
}
