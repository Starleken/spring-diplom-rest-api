package com.example.DiplomRestApi.dto.person;

import lombok.Data;

@Data
public class PersonCreateDto {

    private String surname;
    private String name;
    private String patronymic;
}
