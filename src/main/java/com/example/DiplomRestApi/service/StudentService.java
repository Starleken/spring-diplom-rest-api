package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.entity.Student;
import com.example.DiplomRestApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(Student newStudent, Long id){
        Student student = studentRepository.findById(id).get();

        student.setGroup(newStudent.getGroup());
        student.setUser(newStudent.getUser());
        student.setEducationForm(newStudent.getEducationForm());
        student.setResidentialAddress(newStudent.getResidentialAddress());
        student.setRegistrationAddress(newStudent.getRegistrationAddress());

        return studentRepository.save(student);
    }
}
