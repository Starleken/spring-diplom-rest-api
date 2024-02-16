package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.dto.curator.CuratorUpdateDto;
import com.example.DiplomRestApi.entity.CuratorEntity;

import java.util.List;

public interface CuratorService {
    public List<CuratorFullDto> findAll();

    public CuratorFullDto findCuratorByUser(Long userId);

    public CuratorFullDto create(CuratorCreateDto createDto);

    public CuratorFullDto update(CuratorUpdateDto updateDto);
}
