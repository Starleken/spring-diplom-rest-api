package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
}
