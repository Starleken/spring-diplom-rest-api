package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Data
@Entity
@Table(name = "passports")
public class PassportEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "issue_date", nullable = false)
    private Date issueDate;

    @Column(name = "imageURL", nullable = true)
    private String imageURL;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentEntity student;

    @Column(name = "issuing_organization", nullable = false)
    private String issuingOrganization;
}
