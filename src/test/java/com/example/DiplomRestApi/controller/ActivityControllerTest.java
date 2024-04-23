package com.example.DiplomRestApi.controller;

import com.example.DiplomRestApi.core.BaseIntegrationTest;
import com.example.DiplomRestApi.core.db.ActivityDbHelper;
import com.example.DiplomRestApi.dto.activity.ActivityFullDto;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActivityControllerTest extends BaseIntegrationTest {

    @Autowired
    private ActivityDbHelper dbHelper;

    @Test
    void testFindAll_happyPath() throws Exception {
        //given


        //when
        MvcResult mvcResult = mockMvc.perform(get("/activities"))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var bytes = mvcResult.getResponse().getContentAsByteArray();
        var dtos = objectMapper.readValue(
                bytes, new TypeReference<List<ActivityFullDto>>() {
                });

        Assertions.assertEquals(0, dtos.size());
    }
}
