package com.example.DiplomRestApi.service;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.PassportService;
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
        PassportCreateDTO passportToSaveDto = generatePassportDTO();

        PassportFullDTO savedPassportDto = passportService.create(passportToSaveDto);

        Assertions.assertNotNull(savedPassportDto.getId());
    }

    private PassportCreateDTO generatePassportDTO(){
        PassportCreateDTO passport = new PassportCreateDTO();

        StudentEntity findedStudent = studentRepository.findAll().get(0);

        passport.setNumber(Long.toString(142412));
        passport.setSeries(Long.toString(41));
        passport.setImageURL("faker.company().url()");
        passport.setStudentId(findedStudent.getId());

        return passport;
    }
}
