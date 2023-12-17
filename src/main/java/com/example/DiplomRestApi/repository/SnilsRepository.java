package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.SnilsEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnilsRepository extends JpaRepository<SnilsEntity, Long> {

    List<SnilsEntity> findAllByStudent(StudentEntity student);
}
