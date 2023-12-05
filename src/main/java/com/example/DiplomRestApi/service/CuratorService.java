package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.CuratorEntity;

import java.util.List;

public interface CuratorService {
    public List<CuratorEntity> findAll();

    public CuratorEntity findCuratorByUser(Long userId);

    public CuratorEntity create(CuratorEntity curatorEntity);

    public CuratorEntity update(CuratorEntity curatorEntity);
}
