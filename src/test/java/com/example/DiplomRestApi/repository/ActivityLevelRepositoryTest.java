package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.ActivityLevelEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActivityLevelRepositoryTest {

    private ActivityLevelRepository activityLevelRepository;

    @Autowired
    public ActivityLevelRepositoryTest(ActivityLevelRepository activityLevelRepository) {
        this.activityLevelRepository = activityLevelRepository;
    }

    @BeforeEach
    void setUp() {
        activityLevelRepository.deleteAll();
    }

    @Test
    void findAll_happyPath() {
        //given
        ActivityLevelEntity entity1 = new ActivityLevelEntity();
        entity1.setName("ascasc");

        ActivityLevelEntity entity2 = new ActivityLevelEntity();
        entity2.setName("kajvisa");

        activityLevelRepository.save(entity1);
        activityLevelRepository.save(entity2);

        //when
        List<ActivityLevelEntity> findedEntities = activityLevelRepository.findAll();

        //then
        Assertions.assertNotNull(findedEntities);
        Assertions.assertEquals(entity1.getName(), findedEntities.get(0).getName());
        Assertions.assertEquals(entity2.getName(), findedEntities.get(1).getName());
    }

    @Test
    void create_happyPath() {
        //given
        ActivityLevelEntity entity1 = new ActivityLevelEntity();
        entity1.setName("ascasc");

        //when
        ActivityLevelEntity savedEntity = activityLevelRepository.save(entity1);

        //then
        Assertions.assertNotNull(savedEntity);
        Assertions.assertEquals(entity1.getId(), savedEntity.getId());
        Assertions.assertEquals(entity1.getName(), savedEntity.getName());
    }
}
