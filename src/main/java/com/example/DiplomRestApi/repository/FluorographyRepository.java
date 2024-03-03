package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.FluorographyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FluorographyRepository extends JpaRepository<FluorographyEntity, Long> {

    Optional<FluorographyEntity> findByStudent(StudentEntity student);
}
