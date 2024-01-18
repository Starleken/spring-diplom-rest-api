package com.example.DiplomRestApi.dto.fluVaccine;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class FluVaccineUpdateDto {

    private long id;
    private Date createDate;
    private MultipartFile image;
}
