package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registrationAddress")
    private String registrationAddress;

    @Column(name = "residentialAddress")
    private String residentialAddress;

    @ManyToOne()
    @JoinColumn(name = "educationForm_id")
    private EducationFormEntity educationForm;

    @Column(name = "phone", nullable = true)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
