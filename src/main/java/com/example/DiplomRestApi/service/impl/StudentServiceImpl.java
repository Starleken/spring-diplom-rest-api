package com.example.DiplomRestApi.service.impl;

import com.example.DiplomRestApi.entity.GroupEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.entity.UserEntity;
import com.example.DiplomRestApi.repository.GroupRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.repository.UserRepository;
import com.example.DiplomRestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }

    public List<StudentEntity> findStudentsByGroup(Long groupId){
        Optional<GroupEntity> findedGroup = groupRepository.findById(groupId);

        //TODO
        if (findedGroup.isEmpty()){
            return null;
        }

        return studentRepository.findStudentsByGroup(findedGroup.get());
    }

    @Override
    public StudentEntity findStudentByUser(Long userId) {
        Optional<UserEntity> findedUser = userRepository.findById(userId);

        //TODO
        if (findedUser.isEmpty()){
            return null;
        }

        return studentRepository.findStudentByUser(findedUser.get());
    }

    public StudentEntity save(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    public StudentEntity update(StudentEntity newStudentEntity){
        StudentEntity studentEntity = studentRepository.findById(newStudentEntity.getId()).get();

        studentEntity.setGroup(newStudentEntity.getGroup());
        studentEntity.setUser(newStudentEntity.getUser());
        studentEntity.setEducationForm(newStudentEntity.getEducationForm());
        studentEntity.setResidentialAddress(newStudentEntity.getResidentialAddress());
        studentEntity.setRegistrationAddress(newStudentEntity.getRegistrationAddress());

        return studentRepository.save(studentEntity);
    }
}
