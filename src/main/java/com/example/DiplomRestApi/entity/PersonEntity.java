package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "patronymic", nullable = true)
    private String patronymic;
}
