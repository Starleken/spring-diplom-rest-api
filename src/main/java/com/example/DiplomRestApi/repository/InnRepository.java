package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.InnEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InnRepository extends JpaRepository<InnEntity, Long> {

    List<InnEntity> findAllByStudent(StudentEntity student);
}
