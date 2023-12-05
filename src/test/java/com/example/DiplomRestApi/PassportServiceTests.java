package com.example.DiplomRestApi;

import com.example.DiplomRestApi.dto.passport.PassportCreateDTO;
import com.example.DiplomRestApi.dto.passport.PassportFullDTO;
import com.example.DiplomRestApi.entity.PassportEntity;
import com.example.DiplomRestApi.entity.StudentEntity;
import com.example.DiplomRestApi.repository.PassportRepository;
import com.example.DiplomRestApi.repository.StudentRepository;
import com.example.DiplomRestApi.service.PassportService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PassportServiceTests {
    private StudentRepository studentRepository;
    private PassportService passportService;

    @Autowired
    public PassportServiceTests(PassportService passportService, StudentRepository studentRepository) {
        this.passportService = passportService;
        this.studentRepository = studentRepository;
    }

    @Test
    void create_happyPath() {
        PassportCreateDTO passportToSaveDto = generatePassportDTO();

        PassportFullDTO savedPassportDto = passportService.create(passportToSaveDto);

        Assertions.assertNotNull(savedPassportDto.getId());
    }

    private PassportCreateDTO generatePassportDTO(){
        Faker faker = new Faker();
        PassportCreateDTO passport = new PassportCreateDTO();

        StudentEntity findedStudent = studentRepository.findAll().get(0);

        passport.setNumber(Long.toString(faker.number().randomNumber()));
        passport.setSeries(Long.toString(faker.number().randomNumber()));
        passport.setImageURL(faker.company().url());
        passport.setStudentId(findedStudent.getId());

        return passport;
    }
}
