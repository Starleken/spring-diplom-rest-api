package com.example.DiplomRestApi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.Objects;

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
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private ActivityTypeEntity activityType;

    @ManyToOne
    @JoinColumn(name = "activityLevel_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private ActivityLevelEntity activityLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private UserEntity user;
}
