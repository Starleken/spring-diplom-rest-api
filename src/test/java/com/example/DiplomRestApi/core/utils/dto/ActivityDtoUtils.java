package com.example.DiplomRestApi.core.utils.dto;

import com.example.DiplomRestApi.core.utils.FakerUtils;
import com.example.DiplomRestApi.dto.activity.ActivityCreateDto;

import static com.example.DiplomRestApi.core.utils.FakerUtils.*;

public abstract class ActivityDtoUtils {

    public static ActivityCreateDto generateCreateDto(long studentId) {
        return ActivityCreateDto.builder()
                .name(FAKER.name().name())
                .activityLevelId(0L)
                .activityTypeId(0L)
                .date(FAKER.date().birthday())
                .eventPlace(FAKER.address().fullAddress())
                .place(FAKER.number().randomDigit())
                .studentId(studentId)
                .build();
    }
}
