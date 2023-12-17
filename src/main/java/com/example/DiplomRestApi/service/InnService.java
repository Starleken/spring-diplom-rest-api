package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.InnEntity;

import java.util.List;

public interface InnService {

    List<InnEntity> findAll();

    InnEntity create(InnEntity entity);

    InnEntity update(InnEntity entity);

    void delete(Long id);
}
