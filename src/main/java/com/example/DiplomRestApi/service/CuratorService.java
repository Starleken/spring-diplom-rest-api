package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.dto.curator.CuratorUpdateDto;
import com.example.DiplomRestApi.entity.CuratorEntity;

import java.util.List;

public interface CuratorService {
    List<CuratorFullDto> findAll();

    CuratorFullDto findCuratorByUser(Long userId);

    CuratorFullDto create(CuratorCreateDto createDto);

    CuratorFullDto update(CuratorUpdateDto updateDto);
}
