package com.example.DiplomRestApi.dto.user;

import com.example.DiplomRestApi.dto.person.PersonUpdateDto;
import lombok.Data;

@Data
public class UserUpdateDto {

    private Long id;
    private String login;
    private String password;
    private Long roleId;
    private PersonUpdateDto person;
}
