package com.example.DiplomRestApi.repository;

import com.example.DiplomRestApi.entity.GroupEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GroupRepositoryTest {

    private GroupRepository groupRepository;

    @Autowired
    public GroupRepositoryTest(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @BeforeEach
    void setUp() {
        groupRepository.deleteAll();
    }

    @Test
    void findAll_happyPath() {
        //given
        GroupEntity entity1 = new GroupEntity();
        entity1.setName("casca");

        GroupEntity entity2 = new GroupEntity();
        entity2.setName("vxzczx");

        groupRepository.save(entity1);
        groupRepository.save(entity2);

        //when
        List<GroupEntity> findedEntities = groupRepository.findAll();

        //then
        Assertions.assertNotNull(findedEntities);
        Assertions.assertEquals(entity1.getName(), findedEntities.get(0).getName());
        Assertions.assertEquals(entity2.getName(), findedEntities.get(1).getName());
    }

    @Test
    void create_happyPath() {
        //given
        GroupEntity entity1 = new GroupEntity();
        entity1.setName("casca");

        //when
        GroupEntity savedEntity = groupRepository.save(entity1);

        //then
        Assertions.assertNotNull(savedEntity);
        Assertions.assertNotNull(savedEntity.getId());
        Assertions.assertEquals(entity1.getName(), savedEntity.getName());
    }
}
