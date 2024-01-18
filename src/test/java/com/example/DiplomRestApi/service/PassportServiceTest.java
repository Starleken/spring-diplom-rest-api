package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.passport.PassportCreateDto;
import com.example.DiplomRestApi.dto.passport.PassportFullDto;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PassportServiceTest {
    private StudentRepository studentRepository;
    private PassportService passportService;

    @Autowired
    public PassportServiceTest(PassportService passportService, StudentRepository studentRepository) {
        this.passportService = passportService;
        this.studentRepository = studentRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void create_happyPath() {
        PassportCreateDto passportToSaveDto = generatePassportDTO();

        PassportFullDto savedPassportDto = passportService.create(passportToSaveDto);

        Assertions.assertNotNull(savedPassportDto.getId());
    }

    private PassportCreateDto generatePassportDTO(){
        PassportCreateDto passport = new PassportCreateDto();

        StudentEntity findedStudent = studentRepository.findAll().get(0);

        passport.setNumber(Long.toString(142412));
        passport.setSeries(Long.toString(41));
        passport.setImageURL("faker.company().url()");
        passport.setStudentId(findedStudent.getId());

        return passport;
    }
}
