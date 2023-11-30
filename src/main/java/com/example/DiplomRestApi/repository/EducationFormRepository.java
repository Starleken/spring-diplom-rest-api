package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.EducationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationFormRepository extends JpaRepository<EducationForm, Long> {
}
