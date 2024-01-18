package com.example.DiplomRestApi.dto.fluVaccine;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class FluVaccineCreateDto {

    private Date createDate;
    private long studentId;
    private MultipartFile image;
}
