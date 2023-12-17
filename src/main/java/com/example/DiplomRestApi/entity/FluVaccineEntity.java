package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Data
@Entity
@Table(name = "flu_vaccines")
public class FluVaccineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @OneToOne()
    @JoinColumn(name = "id_student", nullable = false)
    private StudentEntity student;

    @Column(name = "imageURL", nullable = true)
    private String imageURL;
}
