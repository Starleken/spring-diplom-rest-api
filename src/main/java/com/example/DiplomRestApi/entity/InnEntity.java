package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inn")
public class InnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @OneToOne()
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @Column(name = "imageURL")
    private String imageURL;
}
