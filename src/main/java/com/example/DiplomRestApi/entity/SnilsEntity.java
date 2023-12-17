package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "snils")
public class SnilsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @OneToOne
    @JoinColumn(name = "id_student", nullable = false)
    private StudentEntity student;

    @Column(name = "imageURL", nullable = true)
    private String imageURL;
}
