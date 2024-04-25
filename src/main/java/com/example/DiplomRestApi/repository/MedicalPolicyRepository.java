package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.MedicalPolicyEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalPolicyRepository extends JpaRepository<MedicalPolicyEntity, Long> {

    Optional<MedicalPolicyEntity> findByStudent(StudentEntity student);
}
