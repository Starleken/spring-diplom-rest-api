package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.Curator;
import com.example.DiplomRestApi.repository.CuratorRepository;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Curator create(Curator curator){
        return curatorRepository.save(curator);
    }

    @Override
    public Curator update(Curator curator) {
        Optional<Curator> curatorToChange = curatorRepository.findById(curator.getId());

        if (curatorToChange.isEmpty()){
            return null;
        }

        Curator curatorToUpdate = curatorToChange.get();
        curatorToUpdate.setUser(curator.getUser());

        return curatorRepository.save(curatorToUpdate);
    }
}
