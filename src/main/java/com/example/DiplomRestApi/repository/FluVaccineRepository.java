package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.FluVaccineEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FluVaccineRepository extends JpaRepository<FluVaccineEntity, Long> {

    List<FluVaccineEntity> findAllByStudent(StudentEntity student);
}
