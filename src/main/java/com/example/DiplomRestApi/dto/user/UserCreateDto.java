package com.example.DiplomRestApi.dto.user;

import com.example.DiplomRestApi.dto.person.PersonCreateDto;
import lombok.Data;

@Data
public class UserCreateDto {

    private String login;
    private String password;
    private PersonCreateDto person;
    private long roleId;
}
