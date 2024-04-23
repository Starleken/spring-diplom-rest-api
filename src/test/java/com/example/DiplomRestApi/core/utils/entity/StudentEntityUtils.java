package com.example.DiplomRestApi.core.utils.entity;

import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.entity.UserEntity;

public abstract class StudentEntityUtils {

    public static StudentEntity generateStudent() {
        var student = new StudentEntity();

        return student;
    }
}
