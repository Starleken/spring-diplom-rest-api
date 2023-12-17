package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.repository.InnRepository;
import com.example.DiplomRestApi.service.InnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InnServiceImpl implements InnService {

    private final InnRepository innRepository;

    @Override
    public List<InnEntity> findAll() {
        return innRepository.findAll();
    }

    @Override
    public InnEntity create(InnEntity entity) {
        return innRepository.save(entity);
    }

    @Override
    public InnEntity update(InnEntity entity) {
        Optional<InnEntity> findedEntity = innRepository
                .findById(entity.getId());

        //TODO
        if (findedEntity.isEmpty()){
            return null;
        }

        InnEntity entityToUpdate = findedEntity.get();
        entityToUpdate.setNumber(entity.getNumber());
        entityToUpdate.setImageURL(entity.getImageURL());

        return entityToUpdate;
    }

    @Override
    public void delete(Long id) {
        innRepository.deleteById(id);
    }
}
