package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Data
@Entity
@Table(name = "activities")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date date;

    @Column(nullable = false)
    private Integer place;

    @Column
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "activityType_id")
    private ActivityTypeEntity activityType;

    @ManyToOne
    @JoinColumn(name = "activityLevel_id")
    private ActivityLevelEntity activityLevel;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;
}
