package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Curator;
import com.example.DiplomRestApi.repository.CuratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuratorService {
    private CuratorRepository curatorRepository;

    @Autowired
    public CuratorService(CuratorRepository curatorRepository) {
        this.curatorRepository = curatorRepository;
    }

    public List<Curator> findAll(){
        return curatorRepository.findAll();
    }
}
