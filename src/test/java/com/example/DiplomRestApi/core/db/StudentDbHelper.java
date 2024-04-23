package com.example.DiplomRestApi.core.db;

import com.example.DiplomRestApi.core.utils.entity.StudentEntityUtils;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.StudentRepository;
import org.springframework.stereotype.Component;

import static com.example.DiplomRestApi.core.utils.entity.StudentEntityUtils.*;

@Component
public class StudentDbHelper {

    private StudentRepository studentRepository;

    public void clear() {
        studentRepository.deleteAll();
    }

    public StudentEntity save() {
        var student = generateStudent();

        return studentRepository.save(student);
    }
}
