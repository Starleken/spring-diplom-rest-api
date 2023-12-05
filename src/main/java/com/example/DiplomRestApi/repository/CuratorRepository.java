package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.CuratorEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepository extends JpaRepository<CuratorEntity, Long> {
    public CuratorEntity findCuratorByUser(UserEntity userEntity);
}
