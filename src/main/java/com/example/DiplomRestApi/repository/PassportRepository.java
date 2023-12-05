package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
    public List<PassportEntity> findAllByStudent(StudentEntity student);
}
