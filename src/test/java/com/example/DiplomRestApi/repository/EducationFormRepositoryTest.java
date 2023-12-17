package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.EducationFormEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EducationFormRepositoryTest {

    private EducationFormRepository educationFormRepository;

    @Autowired
    public EducationFormRepositoryTest(EducationFormRepository educationFormRepository) {
        this.educationFormRepository = educationFormRepository;
    }

    @BeforeEach
    void startUp(){
        educationFormRepository.deleteAll();
    }

    @Test
    void findAll() {
        //given
        EducationFormEntity entity1 = new EducationFormEntity();
        entity1.setName("1241241");

        EducationFormEntity entity2 = new EducationFormEntity();
        entity2.setName("Vascas");

        educationFormRepository.save(entity1);
        educationFormRepository.save(entity2);

        //when
        List<EducationFormEntity> entities = educationFormRepository.findAll();

        //then
        Assertions.assertNotNull(entities);
        Assertions.assertEquals(entity1.getName(), entities.get(0).getName());
        Assertions.assertEquals(entity2.getName(), entities.get(1).getName());
    }

    @Test
    void create_happyPath(){
        //given
        EducationFormEntity entity1 = new EducationFormEntity();
        entity1.setName("1241241");

        //when
        EducationFormEntity savedEntity = educationFormRepository.save(entity1);

        //then
        Assertions.assertNotNull(savedEntity);
        Assertions.assertNotNull(savedEntity.getId());
        Assertions.assertEquals(entity1.getName(), savedEntity.getName());
    }
}
