package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLoginAndPassword(String login, String password);
    Optional<UserEntity> findByLogin(String login);
}
