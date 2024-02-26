package com.example.DiplomRestApi.dto.student;

import com.example.DiplomRestApi.dto.user.UserUpdateDto;
import lombok.Data;

@Data
public class StudentUpdateDto {

    private long id;
    private String registrationAddress;
    private String residentialAddress;
    private String phone;
    private long educationFormId;
    private UserUpdateDto user;
    private long groupId;
}
