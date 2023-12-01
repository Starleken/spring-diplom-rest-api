package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLevelRepository extends JpaRepository<ActivityLevel, Long> {
}
