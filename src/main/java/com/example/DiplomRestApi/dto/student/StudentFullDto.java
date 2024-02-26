package com.example.DiplomRestApi.dto.student;

import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import lombok.Data;

@Data
public class StudentFullDto {

    private Long id;
    private String registrationAddress;
    private String residentialAddress;
    private String phone;
    private EducationFormFullDto educationForm;
    private UserFullDto user;
    private GroupFullDto group;
}
