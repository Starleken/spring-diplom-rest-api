package com.example.DiplomRestApi.dto.passport;

import com.example.DiplomRestApi.dto.student.StudentFullDto;
import com.example.DiplomRestApi.entity.StudentEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class PassportFullDto {

    private Long id;
    private String series;
    private String number;
    private Date issueDate;
    private String issuingOrganization;
    private StudentFullDto student;
    private String imageURL;
}
