package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

    public List<ActivityEntity> findActivitiesByUser(UserEntity userEntity);
}
