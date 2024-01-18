package com.example.DiplomRestApi.dto.person;

import lombok.Data;

@Data
public class PersonFullDto {

    private Long id;
    private String surname;
    private String name;
    private String patronymic;
}
