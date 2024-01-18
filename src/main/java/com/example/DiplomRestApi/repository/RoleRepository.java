package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
