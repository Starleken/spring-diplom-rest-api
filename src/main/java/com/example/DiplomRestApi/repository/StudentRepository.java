package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    public List<StudentEntity> findStudentsByGroup(GroupEntity groupEntity);

    public StudentEntity findStudentByUser(UserEntity userEntity);

}
