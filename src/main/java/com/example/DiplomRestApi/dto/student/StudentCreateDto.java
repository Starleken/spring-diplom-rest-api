package com.example.DiplomRestApi.dto.student;

import com.example.DiplomRestApi.dto.user.UserCreateDto;
import lombok.Data;

@Data
public class StudentCreateDto {

    private long educationFormId;
    private UserCreateDto user;
    private long groupId;
}
