package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.SnilsEntity;

import java.util.List;

public interface SnilsService {

    List<SnilsEntity> findAll();

    List<SnilsEntity> findAllByStudent(Long studentId);

    SnilsEntity create(SnilsEntity entity);

    SnilsEntity update(SnilsEntity entity);

    void delete(Long id);
}
