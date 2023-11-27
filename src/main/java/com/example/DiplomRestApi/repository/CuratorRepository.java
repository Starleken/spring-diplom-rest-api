package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.Curator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepository extends JpaRepository<Curator, Long> {
}
