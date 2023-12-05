package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityTypeEntity, Long> {
}
