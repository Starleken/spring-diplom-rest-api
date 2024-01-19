package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.mapper.CuratorMapper;
import com.example.DiplomRestApi.repository.CuratorRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.CuratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuratorServiceImpl implements CuratorService {

    private final CuratorRepository curatorRepository;
    private final UserRepository userRepository;

    private final CuratorMapper mapper;

    @Override
    public List<CuratorFullDto> findAll(){
        List<CuratorEntity> entities = curatorRepository.findAll();

        List<CuratorFullDto> dtos = entities.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public CuratorFullDto findCuratorByUser(Long userId) {
        Optional<UserEntity> findedUser = userRepository.findById(userId);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }

        CuratorEntity finded = curatorRepository.findCuratorByUser(findedUser.get());
        return mapper.mapToDto(finded);
    }

    @Override
    public CuratorFullDto create(CuratorEntity curatorEntity){
        CuratorEntity saved = curatorRepository.save(curatorEntity);

        return mapper.mapToDto(saved);
    }

    @Override
    public CuratorFullDto update(CuratorEntity curatorEntity) {
        Optional<CuratorEntity> curatorToChange = curatorRepository.findById(curatorEntity.getId());

        if (curatorToChange.isEmpty()){
            return null;
        }

        CuratorEntity curatorEntityToUpdate = curatorToChange.get();
        curatorEntityToUpdate.setUser(curatorEntity.getUser());

        CuratorEntity updated = curatorRepository.save(curatorEntityToUpdate);
        return mapper.mapToDto(updated);
    }
}
