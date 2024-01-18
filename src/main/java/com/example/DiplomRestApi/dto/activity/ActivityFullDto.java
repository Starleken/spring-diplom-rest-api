package com.example.DiplomRestApi.dto.activity;

import lombok.Data;

import java.sql.Date;

@Data
public class ActivityFullDto {

    private Long id;
    private String name;
    private Date date;
    private Integer place;
    private String imageUrl;
}
