package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Curator;

import java.util.List;

public interface CuratorService {
    public List<Curator> findAll();

    public Curator create(Curator curator);

    public Curator update(Curator curator);
}
