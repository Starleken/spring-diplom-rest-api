package com.example.DiplomRestApi.dto.person;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonUpdateDto {

    private Long id;
    private String surname;
    private String name;
    private String patronymic;
}
