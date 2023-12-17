package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityTypeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActivityTypeRepositoryTest {

    private ActivityTypeRepository activityTypeRepository;

    @Autowired
    public ActivityTypeRepositoryTest(ActivityTypeRepository activityRepository) {
        this.activityTypeRepository = activityRepository;
    }

    @BeforeEach
    void setUp() {
        activityTypeRepository.deleteAll();
    }

    @Test
    void findAll_happyPath() {
        //given
        ActivityTypeEntity entity1 = new ActivityTypeEntity();
        entity1.setName("12412");

        ActivityTypeEntity entity2 = new ActivityTypeEntity();
        entity2.setName("svds");

        activityTypeRepository.save(entity1);
        activityTypeRepository.save(entity2);

        //when
        List<ActivityTypeEntity> entities = activityTypeRepository.findAll();

        //then
        Assertions.assertNotNull(entities);
        Assertions.assertEquals(entity1.getName(), entities.get(0).getName());
        Assertions.assertEquals(entity2.getName(), entities.get(1).getName());
    }

    @Test
    void create_happyPath(){
        //given
        ActivityTypeEntity entity1 = new ActivityTypeEntity();
        entity1.setName("12412");

        //when
        ActivityTypeEntity savedEntity = activityTypeRepository.save(entity1);

        //then
        Assertions.assertNotNull(savedEntity);
        Assertions.assertNotNull(savedEntity.getId());
        Assertions.assertEquals(entity1.getName(), savedEntity.getName());
    }
}
