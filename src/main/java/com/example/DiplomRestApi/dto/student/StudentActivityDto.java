package com.example.DiplomRestApi.dto.student;

import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.example.DiplomRestApi.dto.educationForm.EducationFormFullDto;
import com.example.DiplomRestApi.dto.group.GroupFullDto;
import com.example.DiplomRestApi.dto.user.UserFullDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentActivityDto {

    private Long id;
    private String registrationAddress;
    private String residentialAddress;
    private String phone;
    private EducationFormFullDto educationForm;
    private UserFullDto user;
    private GroupFullDto group;
    private List<ActivityFullDto> activities;
}
