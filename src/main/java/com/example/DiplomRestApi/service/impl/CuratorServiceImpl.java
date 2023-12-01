package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.Curator;
import com.example.DiplomRestApi.repository.CuratorRepository;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuratorServiceImpl implements CuratorService {
    private CuratorRepository curatorRepository;

    @Autowired
    public CuratorServiceImpl(CuratorRepository curatorRepository) {
        this.curatorRepository = curatorRepository;
    }

    @Override
    public List<Curator> findAll(){
        return curatorRepository.findAll();
    }
}
