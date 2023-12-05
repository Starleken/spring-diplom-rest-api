package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.repository.CuratorRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuratorServiceImpl implements CuratorService {
    private CuratorRepository curatorRepository;
    private UserRepository userRepository;

    @Autowired
    public CuratorServiceImpl(CuratorRepository curatorRepository, UserRepository userRepository) {
        this.curatorRepository = curatorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CuratorEntity> findAll(){
        return curatorRepository.findAll();
    }

    @Override
    public CuratorEntity findCuratorByUser(Long userId) {
        Optional<UserEntity> findedUser = userRepository.findById(userId);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }

        return curatorRepository.findCuratorByUser(findedUser.get());
    }

    @Override
    public CuratorEntity create(CuratorEntity curatorEntity){
        return curatorRepository.save(curatorEntity);
    }

    @Override
    public CuratorEntity update(CuratorEntity curatorEntity) {
        Optional<CuratorEntity> curatorToChange = curatorRepository.findById(curatorEntity.getId());

        if (curatorToChange.isEmpty()){
            return null;
        }

        CuratorEntity curatorEntityToUpdate = curatorToChange.get();
        curatorEntityToUpdate.setUser(curatorEntity.getUser());

        return curatorRepository.save(curatorEntityToUpdate);
    }
}
