package com.example.DiplomRestApi.dto.user;

import com.example.DiplomRestApi.dto.person.PersonFullDto;
import com.example.DiplomRestApi.dto.role.RoleFullDto;
import com.example.DiplomRestApi.entity.PersonEntity;
import lombok.Data;

@Data
public class UserFullDto {
    private Long id;
    private String login;
    private String password;
    private PersonFullDto person;
    private RoleFullDto role;
}
