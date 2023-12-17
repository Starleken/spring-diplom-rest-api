package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_policies")
public class MedicalPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "imageURL", nullable = true)
    private String imageURL;

    @OneToOne
    @JoinColumn(name = "id_student", nullable = false)
    private StudentEntity student;
}
