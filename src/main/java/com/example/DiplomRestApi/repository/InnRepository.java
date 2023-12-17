package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.InnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnRepository extends JpaRepository<InnEntity, Long> {
}
