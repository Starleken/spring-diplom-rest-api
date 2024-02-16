package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.dto.curator.CuratorCreateDto;
import com.example.DiplomRestApi.dto.curator.CuratorFullDto;
import com.example.DiplomRestApi.dto.curator.CuratorUpdateDto;
import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.entity.RoleEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.exception.EntityNotFoundException;
import com.example.DiplomRestApi.mapper.CuratorMapper;
import com.example.DiplomRestApi.repository.CuratorRepository;
import com.example.DiplomRestApi.repository.GroupRepository;
import com.example.DiplomRestApi.repository.RoleRepository;
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
    private final RoleRepository roleRepository;
    private final GroupRepository groupRepository;

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
    public CuratorFullDto create(CuratorCreateDto createDto){
        CuratorEntity curatorToSave = mapper.mapToEntity(createDto);

        Optional<RoleEntity> findedRole = roleRepository.findById(createDto.getUser().getRoleId());
        if(findedRole.isEmpty()){
            throw new EntityNotFoundException("Role is not found");
        }
        curatorToSave.getUser().setRole(findedRole.get());

        Optional<GroupEntity> findedGroup = groupRepository.findById(createDto.getGroupId());
        if(findedGroup.isEmpty()){
            throw new EntityNotFoundException("Group is not found");
        }
        curatorToSave.setGroup(findedGroup.get());

        CuratorEntity saved = curatorRepository.save(curatorToSave);
        return mapper.mapToDto(saved);
    }

    @Override
    public CuratorFullDto update(CuratorUpdateDto updateDto) {
        Optional<CuratorEntity> finded = curatorRepository.findById(updateDto.getId());

        if(finded.isEmpty()){
            throw new EntityNotFoundException("Curator is not found");
        }
        CuratorEntity curatorToUpdate = finded.get();

        Optional<GroupEntity> findedGroup = groupRepository.findById(updateDto.getGroupId());
        if(findedGroup.isEmpty()){
            throw new EntityNotFoundException("Group is not found");
        }
        curatorToUpdate.setGroup(findedGroup.get());

        curatorToUpdate.getUser().setLogin(updateDto.getUser().getLogin());
        curatorToUpdate.getUser().setPassword(updateDto.getUser().getPassword());
        curatorToUpdate.getUser().getPerson().setName(updateDto.getUser().getPerson().getName());
        curatorToUpdate.getUser().getPerson().setPatronymic(updateDto.getUser().getPerson().getPatronymic());
        curatorToUpdate.getUser().getPerson().setSurname(updateDto.getUser().getPerson().getSurname());

        CuratorEntity updated = curatorRepository.save(curatorToUpdate);
        return mapper.mapToDto(updated);
    }
}
