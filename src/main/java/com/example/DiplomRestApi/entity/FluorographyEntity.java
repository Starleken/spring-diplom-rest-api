package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "fluorographies")
public class FluorographyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "create_date", nullable = true)
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "id_student", nullable = true)
    private StudentEntity student;

    @Column(name = "imageURL", nullable = true)
    private String imageURL;
}
