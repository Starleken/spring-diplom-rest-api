package com.example.DiplomRestApi.dto.medicalPolicy;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MedicalPolicyUpdateDto {

    private Long id;
    private String number;
    private MultipartFile image;
}
