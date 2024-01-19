package com.example.DiplomRestApi.dto.fluVaccine;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import lombok.Data;

import java.sql.Date;

@Data
public class FluVaccineFullDto {

    private Long id;
    private Date createDate;
    private StudentFullDto student;
    private String imageURL;
}
