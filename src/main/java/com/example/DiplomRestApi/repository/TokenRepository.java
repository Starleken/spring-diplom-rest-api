package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.TokenEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByToken(String token);
    List<TokenEntity> findAllByCreatedAtLessThan(long time);
    List<TokenEntity> findAllByUser(UserEntity user);
}
