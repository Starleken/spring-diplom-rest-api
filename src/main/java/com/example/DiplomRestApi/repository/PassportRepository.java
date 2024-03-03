package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
    public Optional<PassportEntity> findByStudent(StudentEntity student);
}
